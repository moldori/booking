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
        return ResponseEntity.ok(guestService.findAll().stream().map(GuestDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(new GuestDTO(guestService.findOne(id)));
    }

    @PostMapping
    public ResponseEntity<GuestDTO> saveGuest(@RequestBody GuestDTO guestDTO) {
        return ResponseEntity.ok(new GuestDTO(guestService.saveGuest(guestDTO)));
    }

    @PutMapping
    public ResponseEntity<GuestDTO> updateGuest(@RequestBody GuestDTO guestDTO) {
        return ResponseEntity.ok(new GuestDTO(guestService.updateGuest(guestDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.ok().build();
    }

}
