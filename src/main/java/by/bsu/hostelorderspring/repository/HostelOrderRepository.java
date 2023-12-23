package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.HostelOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelOrderRepository extends CrudRepository<HostelOrder, Long> {
}
