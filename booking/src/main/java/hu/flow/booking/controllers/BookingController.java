package hu.flow.booking.controllers;

import hu.flow.booking.models.Booking;
import hu.flow.booking.models.dto.BookingDTO;
import hu.flow.booking.models.dto.RoomDTO;
import hu.flow.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findAll() {
        return ResponseEntity.ok(bookingService.findAll().stream().map(BookingDTO::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(new BookingDTO(bookingService.findOne(id)));
    }

    @PostMapping
    public ResponseEntity<BookingDTO> saveBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(new BookingDTO(bookingService.saveBooking(bookingDTO)));
    }

    @PutMapping
    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(new BookingDTO(bookingService.updateBooking(bookingDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/rooms/{roomId}")
    public ResponseEntity<BookingDTO> addRoomToBooking(@PathVariable Long id, @PathVariable Long roomId) {
        return ResponseEntity.ok(new BookingDTO(bookingService.addRoomToBooking(id, roomId)));
    }

    @GetMapping("/current")
    public ResponseEntity<List<BookingDTO>> findAllByHotelId() {
        return ResponseEntity.ok(bookingService.findAllByHotelId().stream().map(BookingDTO::new).collect(Collectors.toList()));
    }



}
