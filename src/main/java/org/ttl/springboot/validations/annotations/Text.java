package org.ttl.springboot.validations.annotations;

import org.ttl.springboot.validations.validators.TextValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TextValidator.class)
public @interface Text {
    String message() default "must be a valid text";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
