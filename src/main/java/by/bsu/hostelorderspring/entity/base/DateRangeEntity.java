package by.bsu.hostelorderspring.entity.base;

import by.bsu.hostelorderspring.validation.group.BeforeInitialized;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DateRangeEntity extends BaseEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Provide start date", groups = BeforeInitialized.class)
    protected LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Provide end date", groups = BeforeInitialized.class)
    protected LocalDate endDate;
}
