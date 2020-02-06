package hu.flow.booking.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.flow.booking.models.Booking;
import hu.flow.booking.models.Guest;
import hu.flow.booking.models.Hotel;
import hu.flow.booking.models.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {

    private Long id;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Hotel hotel;

    private Guest guest;

    private List<RoomDTO> rooms;

    public Booking toEntity() {
        return new Booking(id,
                checkIn,
                checkOut,
                hotel,
                guest,
                rooms.stream().map(RoomDTO::toEntity).collect(Collectors.toList())
        );
    }

    public BookingDTO(Booking booking) {
        this.id = booking.getId();
        this.checkIn = booking.getCheckIn();
        this.checkOut = booking.getCheckOut();
        this.hotel = booking.getHotel();
        this.guest = booking.getGuest();
    }

}
