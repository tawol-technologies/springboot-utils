package org.ttl.springboot.validations.validators;

import org.springframework.beans.factory.annotation.Configurable;
import org.ttl.springboot.validations.annotations.Date;
import org.ttl.springboot.validations.enums.DateMeasures;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Configurable
public class DateValidator implements ConstraintValidator<Date, String> {
    private String format;
    private DateMeasures measure;

    @Override
    public void initialize(Date date) {
        this.format = date.format();
        this.measure = date.measure();
    }

    @Override
    public boolean isValid(String val, ConstraintValidatorContext cvc) {
        if (val == null) return false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(this.format);
            sdf.setLenient(false);
            java.util.Date date = sdf.parse(val);
            java.util.Date today = new java.util.Date();

            switch (this.measure) {
                case BEFORE_TODAY:
                    return date.before(today);
                case AFTER_TODAY:
                    return date.after(today);
                case EARLIER_AND_TODAY:
                    return date.before(today) || date.equals(today);
                case TODAY_AND_LATER:
                    return date.equals(today) || date.after(today);
                default:
                    return true;
            }
        } catch (ParseException e) {
            return false;
        }
    }
}
