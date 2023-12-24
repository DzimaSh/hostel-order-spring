package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
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

    private Integer roomNumber;

    private Long possibleLivers;

    private Double rentPricePerDay;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "rooms")
    private Set<HostelOrder> hostelOrders;
}
