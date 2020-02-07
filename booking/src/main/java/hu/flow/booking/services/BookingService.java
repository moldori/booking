package hu.flow.booking.services;

import hu.flow.booking.models.Booking;
import hu.flow.booking.models.Hotel;
import hu.flow.booking.models.Room;
import hu.flow.booking.models.User;
import hu.flow.booking.models.dto.BookingDTO;
import hu.flow.booking.repositories.BookingRepository;
import hu.flow.booking.repositories.RoomRepository;
import hu.flow.booking.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BookingService {

    private BookingRepository bookingRepository;
    private RoomService roomService;
    private AuthService authService;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findOne(Long id) {
        return bookingRepository.findById(id).orElseThrow();
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

    public Booking addRoomToBooking(Long id, Long roomsId) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        List<Room> listOfRooms = booking.getRooms();
        listOfRooms.add(roomService.findOne(roomsId));
        booking.setRooms(listOfRooms);
        return bookingRepository.save(booking);
    }

    public List<Booking> findAllByHotelId() {
        return bookingRepository.findByHotel_Id(authService.getCurrentHotelId());
    }

}
