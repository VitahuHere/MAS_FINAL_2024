package org.miras.finalproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class FutureDateValidator implements ConstraintValidator<NotFutureDate, LocalDate> {

    @Override
    public void initialize(NotFutureDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.isBefore(LocalDate.now());
    }
}