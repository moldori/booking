package hu.flow.booking.controllers;

import hu.flow.booking.models.Guest;
import hu.flow.booking.models.dto.GuestDTO;
import hu.flow.booking.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public ResponseEntity<List<GuestDTO>> findAll() {
        List<Guest> guestList = guestService.findAll();

        List<GuestDTO> listOfDTOs = guestList.stream().map(guest -> {
            GuestDTO guestDTO = new GuestDTO(guest);
            return guestDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listOfDTOs);

        //return guestService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDTO> findOne(@PathVariable Long id) {
        Guest guest = guestService.findOne(id);

        GuestDTO guestDTO = new GuestDTO(guest);
        return ResponseEntity.ok(guestDTO);
    }

    @PostMapping
    public ResponseEntity<GuestDTO> saveGuest(@RequestBody GuestDTO guestDTO) {
        Guest guest = guestService.saveGuest(guestDTO);
        GuestDTO newGuestDTO = new GuestDTO(guest);
        return ResponseEntity.ok(newGuestDTO);
        // return guestService.saveGuest(guest);
    }

    @PutMapping
    public ResponseEntity<GuestDTO> updateGuest(@RequestBody GuestDTO guestDTO) {
        Guest guest = guestService.updateGuest(guestDTO);
        GuestDTO newGuestDTO = new GuestDTO(guest);
        return ResponseEntity.ok(newGuestDTO);
        //return guestService.updateGuest(guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.ok().build();
    }

}
