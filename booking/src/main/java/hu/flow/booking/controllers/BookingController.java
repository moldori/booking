package hu.flow.booking.controllers;

import hu.flow.booking.models.Booking;
import hu.flow.booking.models.dto.BookingDTO;
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
        List<Booking> bookingList = bookingService.findAll();

        List<BookingDTO> listOfDTOs = bookingList.stream().map(booking -> {
            BookingDTO bookingDTO = new BookingDTO(booking);
            return bookingDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listOfDTOs);

        //return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> findOne(@PathVariable Long id) {
        Booking booking = bookingService.findOne(id);

        BookingDTO bookingDTO = new BookingDTO(booking);
        return ResponseEntity.ok(bookingDTO);
    }

    @PostMapping
    public ResponseEntity<BookingDTO> saveBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingService.saveBooking(bookingDTO);
        BookingDTO newBookingDTO = new BookingDTO(booking);
        return ResponseEntity.ok(newBookingDTO);
        // return bookingService.saveBooking(booking);
    }

    @PutMapping
    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingService.updateBooking(bookingDTO);
        BookingDTO newBookingDTO = new BookingDTO(booking);
        return ResponseEntity.ok(newBookingDTO);
        //return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/rooms/{roomId}")
    public ResponseEntity<BookingDTO> addRoomToBooking(@PathVariable Long id, @PathVariable Long roomId) {
        Booking booking = bookingService.addRoomToBooking(id, roomId);

        BookingDTO bookingDTO = new BookingDTO(booking);
        return ResponseEntity.ok(bookingDTO);
    }



}
