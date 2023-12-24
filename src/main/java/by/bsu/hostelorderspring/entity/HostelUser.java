package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "hostelOrders")
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

    public enum Authority {
        ADMIN,
        USER
    }

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private Set<HostelOrder> hostelOrders;
}
