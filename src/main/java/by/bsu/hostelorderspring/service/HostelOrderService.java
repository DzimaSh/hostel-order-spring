package by.bsu.hostelorderspring.service;

import by.bsu.hostelorderspring.entity.Bill;
import by.bsu.hostelorderspring.entity.HostelOrder;
import by.bsu.hostelorderspring.entity.HostelUser;
import by.bsu.hostelorderspring.entity.Room;
import by.bsu.hostelorderspring.entity.enums.BillStatus;
import by.bsu.hostelorderspring.entity.enums.OrderStatus;
import by.bsu.hostelorderspring.repository.HostelOrderRepository;
import by.bsu.hostelorderspring.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HostelOrderService {

    private final HostelOrderRepository orderRepository;
    private final HostelUserService userService;
    private final RoomService roomService;

    public HostelOrder getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Cannot find order with id %d", orderId)
                ));
    }

    public List<HostelOrder> getOrdersByUser(Long userId) {
        return orderRepository.findByClient(
                userService.getUserById(userId)
        );
    }

    public HostelOrder createOrder(Long clientId, HostelOrder hostelOrder) {
        HostelUser client = userService.getUserById(clientId);
        Bill clientBill = new Bill();
        clientBill.setHostelOrder(hostelOrder);

        hostelOrder.setStatus(OrderStatus.OPEN);
        hostelOrder.setClient(client);
        hostelOrder.setBill(clientBill);

        return orderRepository.save(hostelOrder);
    }

    public List<HostelOrder> getOpenOrders() {
        return orderRepository.findAllByStatus(OrderStatus.OPEN);
    }

    public HostelOrder approve(Long orderId, List<Long> roomIds) {
        HostelOrder orderToApprove = this.getOrderById(orderId);
        Bill orderBill = orderToApprove.getBill();
        Set<Room> selectedRooms = roomIds.stream()
                .map(roomService::getRoomById)
                .collect(Collectors.toSet());

        orderBill.setBillPrice(
                countRent(selectedRooms, orderToApprove.countPeriodOfOrder())
        );
        selectedRooms.forEach(room -> {
            room.addOrders(List.of(orderToApprove));
            room.setStatus(Room.Status.RESERVED);
        });

        orderToApprove.setRooms(selectedRooms);
        orderToApprove.setStatus(OrderStatus.APPROVED);

        return orderRepository.save(orderToApprove);
    }

    private Double countRent(Set<Room> rooms, Long days) {
        Double sumPerDay = rooms.stream()
                .mapToDouble(Room::getRentPricePerDay)
                .sum();

        return days * sumPerDay;
    }
}
