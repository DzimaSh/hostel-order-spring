package by.bsu.hostelorderspring.service;

import by.bsu.hostelorderspring.entity.Room;
import by.bsu.hostelorderspring.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getFreeRooms() {
        return roomRepository.findAllByStatus(Room.Status.FREE);
    }
}
