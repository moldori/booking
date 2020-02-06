package hu.flow.booking.models.dto;

import hu.flow.booking.models.Hotel;
import hu.flow.booking.models.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {

    private Long id;

    private int number;

    private Hotel hotel;

    private List<BookingDTO> bookings;

    public Room toEntity() {
        return new Room(id,
                number,
                hotel,
                bookings.stream().map(BookingDTO::toEntity).collect(Collectors.toList())
        );
    }

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.number= room.getNumber();
        this.hotel = room.getHotel();
        //this.bookings = room.getBookings().stream().map(BookingDTO::getId).collect(Collectors.toList());
    }
}
