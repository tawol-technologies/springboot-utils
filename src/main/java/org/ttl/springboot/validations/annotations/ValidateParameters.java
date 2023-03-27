package org.ttl.springboot.validations.annotations;

import org.ttl.springboot.validations.enums.Validatables;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidateParameters {
    int[] indexes() default {};
    Validatables[] targets() default {};
    String[] regex() default {};
}
