package by.bsu.hostelorderspring.validation;

import by.bsu.hostelorderspring.entity.base.DateRangeEntity;
import by.bsu.hostelorderspring.validation.annotation.DateOrderConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateOrderValidator implements ConstraintValidator<DateOrderConstraint, DateRangeEntity> {

    @Override
    public void initialize(DateOrderConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(DateRangeEntity value, ConstraintValidatorContext context) {
        return value.getStartDate().before(value.getEndDate());
    }
}
