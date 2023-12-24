package by.bsu.hostelorderspring.service;

import by.bsu.hostelorderspring.entity.Bill;
import by.bsu.hostelorderspring.entity.enums.BillStatus;
import by.bsu.hostelorderspring.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public List<Bill> getUnpaidBills() {
        return billRepository.findAllByStatus(BillStatus.NOT_PAYED);
    }
}
