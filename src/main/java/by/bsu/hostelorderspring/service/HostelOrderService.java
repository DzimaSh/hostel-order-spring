package by.bsu.hostelorderspring.service;

import by.bsu.hostelorderspring.entity.HostelOrder;
import by.bsu.hostelorderspring.entity.HostelUser;
import by.bsu.hostelorderspring.entity.enums.OrderStatus;
import by.bsu.hostelorderspring.repository.HostelOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostelOrderService {

    private final HostelOrderRepository orderRepository;
    private final HostelUserService userService;

    public List<HostelOrder> getOrdersByUser(Long userId) {
        return orderRepository.findByClient(
                userService.getUserById(userId)
        );
    }

    public HostelOrder createOrder(Long clientId, HostelOrder hostelOrder) {
        HostelUser client = userService.getUserById(clientId);

        hostelOrder.setStatus(OrderStatus.OPEN);
        hostelOrder.setClient(client);

        return orderRepository.save(hostelOrder);
    }

    public List<HostelOrder> getOpenOrders() {
        return orderRepository.findAllByStatus(OrderStatus.OPEN);
    }
}
