package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.base.BaseEntity;
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
@SequenceGenerator(
        name = "default_seq",
        sequenceName = "hostel_user_seq",
        allocationSize = 1
)
public class HostelUser extends BaseEntity {

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "client")
    private Set<HostelOrder> hostelOrders;
}
