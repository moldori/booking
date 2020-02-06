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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    private List<Booking> bookings;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

}
