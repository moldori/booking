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
        List<Room> roomList = roomService.findAll();

        List<RoomDTO> listOfDTOs = roomList.stream().map(room -> {
            RoomDTO roomDTO = new RoomDTO(room);
            return roomDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listOfDTOs);

        //return roomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findOne(@PathVariable Long id) {
        Room room = roomService.findOne(id);

        RoomDTO roomDTO = new RoomDTO(room);
        return ResponseEntity.ok(roomDTO);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> saveRoom(@RequestBody RoomDTO roomDTO) {
        Room room = roomService.saveRoom(roomDTO);
        RoomDTO newRoomDTO = new RoomDTO(room);
        return ResponseEntity.ok(newRoomDTO);
        // return roomService.saveRoom(room);
    }

    @PutMapping
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO) {
        Room room = roomService.updateRoom(roomDTO);
        RoomDTO newRoomDTO = new RoomDTO(room);
        return ResponseEntity.ok(newRoomDTO);
        //return roomService.updateRoom(Room);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findAllByHotelId/{hotelId}")
    public ResponseEntity<List<RoomDTO>> findAllByHotelId(@PathVariable Long hotelId) {
        List<Room> roomList = roomService.findAllByHotelId(hotelId);

        List<RoomDTO> listOfDTOs = roomList.stream().map(room -> {
            RoomDTO roomDTO = new RoomDTO(room);
            return roomDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listOfDTOs);
    }

}
