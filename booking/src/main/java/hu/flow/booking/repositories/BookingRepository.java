package hu.flow.booking.repositories;

import hu.flow.booking.models.Booking;
import hu.flow.booking.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByHotel_Id(Long id);

}
