package hu.flow.booking.services;

import hu.flow.booking.models.Room;
import hu.flow.booking.models.dto.RoomDTO;
import hu.flow.booking.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findOne(Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    public Room saveRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setNumber(roomDTO.getNumber());
        room.setHotel(roomDTO.getHotel());
        return roomRepository.save(room);
    }

    public Room updateRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setNumber(roomDTO.getNumber());
        room.setHotel(roomDTO.getHotel());
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
