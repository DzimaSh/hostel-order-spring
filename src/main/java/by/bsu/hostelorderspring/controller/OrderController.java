package by.bsu.hostelorderspring.controller;

import by.bsu.hostelorderspring.entity.HostelOrder;
import by.bsu.hostelorderspring.security.HostelUserDetails;
import by.bsu.hostelorderspring.service.HostelOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final HostelOrderService hostelOrderService;

    @GetMapping("/create")
    public String createTemplate(Model model) {
        model.addAttribute("order", new HostelOrder());
        return "orders/createOrder";
    }

    @GetMapping("/view")
    public String viewOrders(Model model,
                             @AuthenticationPrincipal HostelUserDetails userDetails
    ) {
        List<HostelOrder> orders = hostelOrderService.getOrdersByUser(userDetails.getId());
        model.addAttribute("orders", orders);
        return "orders/myOrders";
    }

    @PostMapping
    public String createOrder(@ModelAttribute("order") @Valid HostelOrder order,
                              BindingResult bindingResult,
                              @AuthenticationPrincipal HostelUserDetails userDetails
    ) {
        if (bindingResult.hasErrors()) {
            return "orders/createOrder";
        }
        hostelOrderService.createOrder(userDetails.getId(), order);
        return "redirect:/orders/view";
    }
}
