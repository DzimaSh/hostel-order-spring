package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.enums.BillStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    private Long billPrice;

    private BillStatus status = BillStatus.NOT_PAYED;
}
