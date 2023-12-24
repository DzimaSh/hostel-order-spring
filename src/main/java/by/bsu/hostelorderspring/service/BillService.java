package by.bsu.hostelorderspring.service;

import by.bsu.hostelorderspring.entity.Bill;
import by.bsu.hostelorderspring.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Cannot find order with id %d", billId)
                ));
    }

    public List<Bill> getUnpaidBills() {
        return billRepository.findAllByStatus(Bill.Status.NOT_PAYED);
    }

    public Bill pay(Long billId) {
        Bill billToPay = getBillById(billId);

        billToPay.setStatus(Bill.Status.PAYED);

        return billRepository.save(billToPay);
    }
}
