package by.bsu.hostelorderspring.controller;

import by.bsu.hostelorderspring.entity.HostelOrder;
import by.bsu.hostelorderspring.entity.Room;
import by.bsu.hostelorderspring.service.HostelOrderService;
import by.bsu.hostelorderspring.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final HostelOrderService hostelOrderService;
    private final RoomService roomService;

    @GetMapping("/orders/open")
    public String getOpenOrders(Model model) {
        List<HostelOrder> orders = hostelOrderService.getOpenOrders();
        model.addAttribute("orders", orders);
        return "admin/openOrders";
    }

    @GetMapping("/orders/{orderId}/approve")
    public String getOpenApproveTemplate(@PathVariable(name = "orderId") Long orderId, Model model) {
        HostelOrder order = hostelOrderService.getOrderById(orderId);
        List<Room> availableRooms = roomService.getFreeRooms();

        model.addAttribute("order", order);
        model.addAttribute("availableRooms", availableRooms);
        return "admin/orderApprove";
    }

    @PostMapping("/orders/{orderId}/approve")
    public String approveOrder(@PathVariable(name = "orderId") Long orderId,
                               @RequestParam("selectedRooms") List<Long> selectedRooms) {
        hostelOrderService.approve(orderId, selectedRooms);
        return "redirect:/admin/orders/open";
    }
}
