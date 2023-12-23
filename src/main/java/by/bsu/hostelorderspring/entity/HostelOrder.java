package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "hostel_order")
@AllArgsConstructor
@NoArgsConstructor
public class HostelOrder extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private HostelUser client;

    @ManyToMany
    @JoinTable(
            name = "order_room",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "room_id") }
    )
    private Set<Room> rooms;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
