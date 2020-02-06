package hu.flow.booking.controllers;

import hu.flow.booking.models.Hotel;
import hu.flow.booking.models.dto.HotelDTO;
import hu.flow.booking.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    public HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelDTO>> findAll() {
        return ResponseEntity.ok(hotelService.findAll().stream().map(HotelDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(new HotelDTO(hotelService.findOne(id)));
    }

    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(new HotelDTO(hotelService.saveHotel(hotelDTO)));
    }

    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(new HotelDTO(hotelService.updateHotel(hotelDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok().build();
    }

}
