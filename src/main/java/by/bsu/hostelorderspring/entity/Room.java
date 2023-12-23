package by.bsu.hostelorderspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class Room extends BaseEntity {

    private Long possibleLivers;

    private Long rentPricePerDay;

    @ManyToMany(mappedBy = "rooms")
    private Set<HostelOrder> hostelOrders;
}
