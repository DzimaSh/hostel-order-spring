package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
