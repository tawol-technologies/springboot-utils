package org.ttl.springboot.validations.validators;

import org.springframework.beans.factory.annotation.Configurable;
import org.ttl.springboot.validations.annotations.Username;
import org.ttl.springboot.validations.enums.UsernameType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class UsernameValidator implements ConstraintValidator<Username, String> {
    private UsernameType type;

    @Override
    public void initialize(Username username) {
        this.type = username.type();
    }

    @Override
    public boolean isValid(String val, ConstraintValidatorContext cvc) {
        if (val == null) return false;
        switch (this.type) {
            case NUMERIC:
                return val.matches("\\d{3,}");
            case LETTERS:
                return val.matches("^[a-zA-Z]{3,}");
            case ALPHANUMERIC:
                return val.matches("^[0-9a-zA-Z]{3,}");
            case EMAIL:
                return val.matches("\\A[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +
                        ")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*\\Z");
            default:
                return val.matches("^[0-9a-zA-Z@_.]{3,}");
        }
    }
}
