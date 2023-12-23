package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.HostelUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HostelUserRepository extends CrudRepository<HostelUser, Long> {

    Optional<HostelUser> findByEmail(String email);
}
