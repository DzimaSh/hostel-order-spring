package by.bsu.hostelorderspring.entity;

import jakarta.persistence.*;
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
public class Room extends BaseEntity {

    public enum Type {
        BASIC,
        PREMIUM
    }

    private Long possibleLivers;

    private Double rentPricePerDay;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "rooms")
    private Set<HostelOrder> hostelOrders;
}
