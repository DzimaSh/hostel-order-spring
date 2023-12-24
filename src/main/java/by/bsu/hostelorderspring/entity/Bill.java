package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.base.BaseEntity;
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
@SequenceGenerator(
        name = "default_seq",
        sequenceName = "bill_seq",
        allocationSize = 1
)
public class Bill extends BaseEntity {

    @OneToOne(mappedBy = "bill")
    private HostelOrder hostelOrder;

    private Double billPrice;

    @Enumerated(EnumType.STRING)
    private BillStatus status = BillStatus.NOT_PAYED;
}
