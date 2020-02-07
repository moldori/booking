package hu.flow.booking.utils;

import hu.flow.booking.models.*;
import hu.flow.booking.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Component
@Transactional
@Slf4j
@AllArgsConstructor
public class InitDataLoading {

    private final GuestRepository guestRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    public void init() {
        loadHotels();
        loadUsers();
        loadRooms();
        loadGuests();
        loadBooking();
    }

    private void loadUsers() {
        userRepository.save(User.builder().username("john").password(passwordEncoder.encode("password")).hotel(findHotel(1L)).build());
    }

    private void loadHotels() {
        hotelRepository.save(Hotel.builder().name("Grand Hotel Glorius****").city("Makó").build());
        hotelRepository.save(Hotel.builder().name("Science Hotel****").city("Szeged").build());
        hotelRepository.save(Hotel.builder().name("Art Hotel****").city("Makó").build());
    }


    private void loadRooms() {
        roomRepository.save(Room.builder().number(101).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(102).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(103).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(104).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(105).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(201).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(202).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(203).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(204).hotel(hotelRepository.findById(1L).orElse(null)).build());
        roomRepository.save(Room.builder().number(205).hotel(hotelRepository.findById(1L).orElse(null)).build());

        roomRepository.save(Room.builder().number(101).hotel(hotelRepository.findById(2L).orElse(null)).build());
        roomRepository.save(Room.builder().number(102).hotel(hotelRepository.findById(2L).orElse(null)).build());
        roomRepository.save(Room.builder().number(103).hotel(hotelRepository.findById(2L).orElse(null)).build());
        roomRepository.save(Room.builder().number(104).hotel(hotelRepository.findById(2L).orElse(null)).build());
        roomRepository.save(Room.builder().number(105).hotel(hotelRepository.findById(2L).orElse(null)).build());
        roomRepository.save(Room.builder().number(106).hotel(hotelRepository.findById(2L).orElse(null)).build());

        roomRepository.save(Room.builder().number(101).hotel(hotelRepository.findById(3L).orElse(null)).build());
        roomRepository.save(Room.builder().number(102).hotel(hotelRepository.findById(3L).orElse(null)).build());
        roomRepository.save(Room.builder().number(103).hotel(hotelRepository.findById(3L).orElse(null)).build());
        roomRepository.save(Room.builder().number(104).hotel(hotelRepository.findById(3L).orElse(null)).build());
        roomRepository.save(Room.builder().number(105).hotel(hotelRepository.findById(3L).orElse(null)).build());
        roomRepository.save(Room.builder().number(106).hotel(hotelRepository.findById(3L).orElse(null)).build());
        roomRepository.save(Room.builder().number(107).hotel(hotelRepository.findById(3L).orElse(null)).build());
    }


    private void loadGuests() {
        guestRepository.save(Guest.builder().name("John Smith").dateOfBirth(LocalDate.of(1990, 3,3)).email("johnsmith@valami.com").build());
        guestRepository.save(Guest.builder().name("James Johnson").dateOfBirth(LocalDate.of(1989, 4,3)).email("jamesjohnson@valami.com").build());
        guestRepository.save(Guest.builder().name("Robert Williams").dateOfBirth(LocalDate.of(1988, 5,3)).email("robertwilliams@valami.com").build());
        guestRepository.save(Guest.builder().name("Michael Jones").dateOfBirth(LocalDate.of(1987, 6,3)).email("michaelj@valami.com").build());
        guestRepository.save(Guest.builder().name("William Brown").dateOfBirth(LocalDate.of(1986, 7,3)).email("williamb@valami.com").build());
        guestRepository.save(Guest.builder().name("David Moore").dateOfBirth(LocalDate.of(1985, 8,3)).email("davidm@valami.com").build());
        guestRepository.save(Guest.builder().name("Richard Smith").dateOfBirth(LocalDate.of(1984, 9,3)).email("richards@valami.com").build());
    }

    private Hotel findHotel(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    private Guest findGuest(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    private void loadBooking() {
        bookingRepository.save(Booking.builder().hotel(findHotel(1L)).guest(findGuest(2L)).checkIn(LocalDate.of(2020, 2, 7)).checkOut(LocalDate.of(2020,2,10)).rooms(List.of(roomRepository.findById(1L).orElseThrow())).build());
        bookingRepository.save(Booking.builder().hotel(findHotel(1L)).guest(findGuest(3L)).checkIn(LocalDate.of(2020, 2, 7)).checkOut(LocalDate.of(2020,3,9)).rooms(List.of(roomRepository.findById(2L).orElseThrow())).build());
        bookingRepository.save(Booking.builder().hotel(findHotel(1L)).guest(findGuest(4L)).checkIn(LocalDate.of(2020, 2, 7)).checkOut(LocalDate.of(2020,3,10)).rooms(List.of(roomRepository.findById(3L).orElseThrow())).build());
        bookingRepository.save(Booking.builder().hotel(findHotel(1L)).guest(findGuest(5L)).checkIn(LocalDate.of(2020, 2, 7)).checkOut(LocalDate.of(2020,3,9)).rooms(List.of(roomRepository.findById(4L).orElseThrow())).build());
        bookingRepository.save(Booking.builder().hotel(findHotel(1L)).guest(findGuest(6L)).checkIn(LocalDate.of(2020, 2, 7)).checkOut(LocalDate.of(2020,3,9)).rooms(List.of(roomRepository.findById(5L).orElseThrow())).build());
        bookingRepository.save(Booking.builder().hotel(findHotel(1L)).guest(findGuest(7L)).checkIn(LocalDate.of(2020, 2, 7)).checkOut(LocalDate.of(2020,3,9)).rooms(List.of(roomRepository.findById(6L).orElseThrow())).build());
    }



}
