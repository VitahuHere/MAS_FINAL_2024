package org.miras.finalproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BankNumberValidator implements ConstraintValidator<ValidBankNumber, String> {

    private static final String BANK_NUMBER_PATTERN = "^PL\\d{26}$";

    @Override
    public void initialize(ValidBankNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String bankNumber, ConstraintValidatorContext context) {
        if (bankNumber == null) {
            return true;
        }
        return bankNumber.matches(BANK_NUMBER_PATTERN);
    }
}
