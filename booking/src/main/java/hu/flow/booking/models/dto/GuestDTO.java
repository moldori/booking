package hu.flow.booking.models.dto;

import hu.flow.booking.models.Guest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestDTO {
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    private String email;

    private List<BookingDTO> bookings;

    public Guest toEntity() {
        return new Guest(id,
                name,
                dateOfBirth,
                email,
                bookings.stream().map(BookingDTO::toEntity).collect(Collectors.toList())
            // booking -> booking.toEntity()
        );
    }

    public GuestDTO(Guest guest) {
        this.id = guest.getId();
        this.name = guest.getName();
        this.dateOfBirth = guest.getDateOfBirth();
        this.email = guest.getEmail();
    }
}
