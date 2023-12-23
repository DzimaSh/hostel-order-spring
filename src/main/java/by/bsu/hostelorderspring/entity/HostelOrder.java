package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "hostel_order")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "default_seq",
        sequenceName = "hostel_order_seq",
        allocationSize = 1
)
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

    @Enumerated(EnumType.STRING)
    private Room.Type desiredRoomType;

    private Integer desiredBeds;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
