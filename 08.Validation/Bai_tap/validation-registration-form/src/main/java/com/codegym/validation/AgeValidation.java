package com.codegym.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeValidation implements ConstraintValidator<Age, String> {
    public void initialize(Age constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.equals("")) {
            return false;
        } else {
            LocalDate now = LocalDate.now();
            LocalDate bd = LocalDate.parse(value);
            return now.compareTo(bd) - 18 > 0;
        }
    }

}
