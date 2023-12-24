package by.bsu.hostelorderspring.entity;

import by.bsu.hostelorderspring.entity.base.DateRangeEntity;
import by.bsu.hostelorderspring.validation.annotation.DateOrderConstraint;
import by.bsu.hostelorderspring.validation.group.AfterInitialized;
import by.bsu.hostelorderspring.validation.group.BeforeInitialized;
import jakarta.persistence.*;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = { "rooms", "bill" })
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

    public enum Status {
        OPEN,
        APPROVED,
        PAYED,
        CLOSED,
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    private HostelUser client;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_room",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "room_id") }
    )
    @ToString.Exclude
    private Set<Room> rooms;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Choosing the room type is required", groups = BeforeInitialized.class)
    private Room.Type desiredRoomType;

    @Positive(message = "You cannot specify negative amount of beds", groups = AfterInitialized.class)
    @NotNull(message = "Provide the amount of beds you need", groups = BeforeInitialized.class)
    private Integer desiredBeds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    @ToString.Exclude
    private Bill bill;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Override
    @Future(message = "Start date should be upcoming", groups = AfterInitialized.class)
    public LocalDate getStartDate() {
        return super.getStartDate();
    }

    @Override
    @Future(message = "End date should be upcoming", groups = AfterInitialized.class)
    public LocalDate getEndDate() {
        return super.getEndDate();
    }

    public Long countPeriodOfOrder() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}
