package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.HostelUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelUserRepository extends CrudRepository<HostelUser, Long> {
}
