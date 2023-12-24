package by.bsu.hostelorderspring.validation.annotation;

import by.bsu.hostelorderspring.validation.group.AfterInitialized;
import by.bsu.hostelorderspring.validation.DateOrderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateOrderValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOrderConstraint {
    String message() default "Start date must be before end date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}