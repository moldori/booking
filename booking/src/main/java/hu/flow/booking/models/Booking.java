package hu.flow.booking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkIn;

    private LocalDate checkOut;

    @ManyToOne
    @JoinColumn
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookings")
    private List<Room> rooms;

}
