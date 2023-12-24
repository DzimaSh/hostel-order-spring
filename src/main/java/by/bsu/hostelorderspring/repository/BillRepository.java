package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

    List<Bill> findAllByStatus(Bill.Status status);
}
