package hu.flow.booking.services;

import hu.flow.booking.models.Room;
import hu.flow.booking.models.dto.RoomDTO;
import hu.flow.booking.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findOne(Long id) {
        return roomRepository.findById(id).orElse(null);
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

    public List<Room> findAllByHotelId(Long hotelId) {
        List<Room> listOfRooms = roomRepository.findAll()
                .stream()
                .filter(x -> x.getHotel().getId() == hotelId)
                .collect(Collectors.toList());
        return listOfRooms;


    }

}