package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.enums.BillStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends BaseEntity {
    @OneToOne(mappedBy = "bill")
    private HostelOrder hostelOrder;

    private Double billPrice;

    @Enumerated(EnumType.STRING)
    private BillStatus status = BillStatus.NOT_PAYED;
}
