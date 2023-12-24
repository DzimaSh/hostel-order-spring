package by.bsu.hostelorderspring.repository;

import by.bsu.hostelorderspring.entity.HostelOrder;
import by.bsu.hostelorderspring.entity.HostelUser;
import by.bsu.hostelorderspring.entity.enums.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostelOrderRepository extends CrudRepository<HostelOrder, Long> {

    List<HostelOrder> findByClient(HostelUser client);

    List<HostelOrder> findAllByStatus(OrderStatus status);
}
