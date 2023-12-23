package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.enums.Authority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "hostel_user")
@NoArgsConstructor
@AllArgsConstructor
public class HostelUser extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "client")
    private Set<HostelOrder> hostelOrders;
}
