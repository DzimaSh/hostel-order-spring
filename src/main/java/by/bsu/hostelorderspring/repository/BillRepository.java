package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.Bill;
import by.bsu.hostelorderspring.entity.enums.BillStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    List<Bill> findAllByStatus(BillStatus status);
}
