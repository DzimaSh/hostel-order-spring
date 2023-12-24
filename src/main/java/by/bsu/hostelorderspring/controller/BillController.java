package by.bsu.hostelorderspring.controller;

import by.bsu.hostelorderspring.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping("/{billId}/pay")
    public String payBill(@PathVariable("billId") Long billId) {
        billService.pay(billId);

        return "redirect:/orders/view";
    }
}
