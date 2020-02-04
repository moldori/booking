package hu.flow.booking.services;

import hu.flow.booking.models.Booking;
import hu.flow.booking.models.dto.BookingDTO;
import hu.flow.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findOne(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking saveBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setCheckIn(bookingDTO.getCheckIn());
        booking.setCheckOut(bookingDTO.getCheckOut());
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setCheckIn(bookingDTO.getCheckIn());
        booking.setCheckOut(bookingDTO.getCheckOut());
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

}
