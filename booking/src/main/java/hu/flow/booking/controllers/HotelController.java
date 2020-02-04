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
        List<Hotel> hotelList = hotelService.findAll();

        List<HotelDTO> listOfDTOs = hotelList.stream().map(hotel -> {
           HotelDTO hotelDTO = new HotelDTO(hotel);
           return hotelDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listOfDTOs);

        //return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> findOne(@PathVariable Long id) {
        Hotel hotel = hotelService.findOne(id);

        HotelDTO hotelDTO = new HotelDTO(hotel);
        return ResponseEntity.ok(hotelDTO);
    }

    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelService.saveHotel(hotelDTO);
        HotelDTO newHotelDTO = new HotelDTO(hotel);
        return ResponseEntity.ok(newHotelDTO);
        // return hotelService.saveHotel(hotel);
    }

    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelService.updateHotel(hotelDTO);
        HotelDTO newHotelDTO = new HotelDTO(hotel);
        return ResponseEntity.ok(newHotelDTO);
        //return hotelService.updateHotel(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok().build();
    }

}
