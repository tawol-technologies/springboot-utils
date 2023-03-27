package org.ttl.springboot.validations.validators;

import org.springframework.beans.factory.annotation.Configurable;
import org.ttl.springboot.validations.annotations.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class UUIDValidator implements ConstraintValidator<UUID, String> {
    @Override
    public boolean isValid(String val, ConstraintValidatorContext constraintValidatorContext) {
        if (val == null) return false;
        return val.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
    }
}
