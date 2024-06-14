package org.miras.finalproject.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FutureDateValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotFutureDate {
    String message() default "The date must be in the future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}