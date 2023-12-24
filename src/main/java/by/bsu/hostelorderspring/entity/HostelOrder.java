package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.base.DateRangeEntity;
import by.bsu.hostelorderspring.entity.enums.OrderStatus;
import by.bsu.hostelorderspring.validation.annotation.DateOrderConstraint;
import by.bsu.hostelorderspring.validation.group.AfterInitialized;
import by.bsu.hostelorderspring.validation.group.BeforeInitialized;
import jakarta.persistence.*;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.groups.Default;
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
@SequenceGenerator(
        name = "default_seq",
        sequenceName = "hostel_order_seq",
        allocationSize = 1
)
@GroupSequence({ HostelOrder.class, BeforeInitialized.class, AfterInitialized.class })
@DateOrderConstraint(groups = { AfterInitialized.class })
public class HostelOrder extends DateRangeEntity {

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
    @NotNull(message = "Choosing the room type is required", groups = BeforeInitialized.class)
    private Room.Type desiredRoomType;

    @Positive(message = "You cannot specify negative amount of beds", groups = AfterInitialized.class)
    @NotNull(message = "Provide the amount of beds you need", groups = BeforeInitialized.class)
    private Integer desiredBeds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Override
    @Future(message = "Start date should be upcoming", groups = AfterInitialized.class)
    public Date getStartDate() {
        return super.getStartDate();
    }

    @Override
    @Future(message = "End date should be upcoming", groups = AfterInitialized.class)
    public Date getEndDate() {
        return super.getEndDate();
    }
}
