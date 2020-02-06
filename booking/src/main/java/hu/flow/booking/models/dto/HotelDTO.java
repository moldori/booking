package hu.flow.booking.models.dto;


import hu.flow.booking.models.Hotel;
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
public class HotelDTO {

    private Long id;

    private String name;

    private String city;

    private List<BookingDTO> bookings;

    private List<RoomDTO> rooms;

    public Hotel toEntity() {
        return new Hotel(id,
                name,
                city,
                bookings.stream().map(BookingDTO::toEntity).collect(Collectors.toList()),
                rooms.stream().map(RoomDTO::toEntity).collect(Collectors.toList())
        );
    }

    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.city = hotel.getCity();
    }

}
