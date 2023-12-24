package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Collection;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "hostelOrders")
@Data
@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "default_seq",
        sequenceName = "room_seq",
        allocationSize = 1
)
public class Room extends BaseEntity {

    public enum Type {
        BASIC,
        PREMIUM
    }

    public enum Status {
        FREE,
        RESERVED,
        OCCUPIED
    }

    private Integer roomNumber;

    private Long possibleLivers;

    private Double rentPricePerDay;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "rooms")
    @ToString.Exclude
    private Set<HostelOrder> hostelOrders;

    public Room addOrders(Collection<HostelOrder> orders) {
        this.getHostelOrders().addAll(orders);

        return this;
    }
}
