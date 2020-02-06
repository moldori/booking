package hu.flow.booking.controllers;

import hu.flow.booking.models.Room;
import hu.flow.booking.models.dto.RoomDTO;
import hu.flow.booking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll() {
        return ResponseEntity.ok(roomService.findAll().stream().map(RoomDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(new RoomDTO(roomService.findOne(id)));
    }

    @PostMapping
    public ResponseEntity<RoomDTO> saveRoom(@RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(new RoomDTO(roomService.saveRoom(roomDTO)));
    }

    @PutMapping
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(new RoomDTO(roomService.updateRoom(roomDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findAllByHotelId/{hotelId}")
    public ResponseEntity<List<RoomDTO>> findAllByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.findAllByHotelId(hotelId).stream().map(RoomDTO::new).collect(Collectors.toList()));
    }

}
