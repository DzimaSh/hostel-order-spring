package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAllByStatus(Room.Status status);
}
