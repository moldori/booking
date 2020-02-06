package hu.flow.booking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @JsonIgnore
    @ManyToMany
    private List<Booking> bookings;
}
