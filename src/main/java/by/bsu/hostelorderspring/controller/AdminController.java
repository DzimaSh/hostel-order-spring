package by.bsu.hostelorderspring.controller;

import by.bsu.hostelorderspring.entity.HostelOrder;
import by.bsu.hostelorderspring.service.HostelOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final HostelOrderService hostelOrderService;

    @GetMapping("/orders/open")
    public String getOpenOrders(Model model) {
        List<HostelOrder> orders = hostelOrderService.getOpenOrders();
        model.addAttribute("orders", orders);
        return "admin/openOrders";
    }
}
