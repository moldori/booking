package hu.flow.booking.services;

import hu.flow.booking.models.Guest;
import hu.flow.booking.models.dto.GuestDTO;
import hu.flow.booking.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findOne(Long id) {
        return guestRepository.findById(id).orElseThrow();
    }

    public Guest saveGuest(GuestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setName(guestDTO.getName());
        guest.setDateOfBirth(guestDTO.getDateOfBirth());
        guest.setEmail(guestDTO.getEmail());
        return guestRepository.save(guest);
    }

    public Guest updateGuest(GuestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setId(guestDTO.getId());
        guest.setName(guestDTO.getName());
        guest.setDateOfBirth(guestDTO.getDateOfBirth());
        guest.setEmail(guestDTO.getEmail());
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

}
