package org.ttl.springboot.validations.annotations;


import org.ttl.springboot.validations.enums.DateMeasures;
import org.ttl.springboot.validations.validators.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface Date {
    String message() default "must be a valid date";
    String format() default "dd-MMM-yyyy";
    DateMeasures measure() default DateMeasures.ANY;
    String before() default "";
    String after() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
