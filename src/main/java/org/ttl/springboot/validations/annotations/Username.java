package org.ttl.springboot.validations.annotations;

import org.ttl.springboot.validations.enums.UsernameType;
import org.ttl.springboot.validations.validators.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
public @interface Username {
    String message() default "must be a well-formed username";
    UsernameType type() default UsernameType.ANY;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
