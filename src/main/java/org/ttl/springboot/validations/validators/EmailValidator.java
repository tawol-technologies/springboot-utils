package org.ttl.springboot.validations.validators;

import org.springframework.beans.factory.annotation.Configurable;
import org.ttl.springboot.validations.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public boolean isValid(String val, ConstraintValidatorContext constraintValidatorContext) {
        if (val == null) return false;
        return val.matches("^[A-Za-z]+[A-Za-z0-9_.]*@[A-Za-z]{2,}[A-Za-z-.]*\\.[A-Za-z]{2,3}");
    }
}
