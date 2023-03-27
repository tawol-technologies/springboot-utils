package org.ttl.springboot.validations.validators;

import org.springframework.beans.factory.annotation.Configurable;
import org.ttl.springboot.validations.annotations.Text;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class TextValidator implements ConstraintValidator<Text, String> {
    @Override
    public boolean isValid(String val, ConstraintValidatorContext constraintValidatorContext) {
        if (val == null) return false;
        return val.matches("^[A-Za-z]{0,}");
    }
}
