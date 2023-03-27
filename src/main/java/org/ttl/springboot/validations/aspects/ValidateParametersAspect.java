package org.ttl.springboot.validations.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.ttl.springboot.validations.annotations.ValidateParameters;

import java.lang.reflect.Method;

@Aspect
@Component
public class ValidateParametersAspect {
    @Before(
            "@annotation(org.ttl.springboot.validations.annotations.ValidateParameters)"
    )
    public void validateParameters(JoinPoint jp) throws Exception {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        ValidateParameters vp = method.getAnnotation(ValidateParameters.class);
        int[] indexes = vp.indexes();
        for (int i = 0; i < indexes.length; i++) {
            switch (vp.targets()[i]) {
                case USERNAME:
                    String username = (String) jp.getArgs()[indexes[i]];
                    if (
                            (!username.matches("[0-9A-Za-z@.]{3,}")) ||
                                    (vp.regex().length > i && !username.matches(vp.regex()[i]))
                    ){
                        throw new Exception(
                                "Username can only be alphanumeric and cannot be less than 3"
                        );
                    }
                    break;
                case ID:
                    String id = (String) jp.getArgs()[indexes[i]];
                    if (
                            (!id.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) ||
                                    (vp.regex().length > i && !id.matches(vp.regex()[i]))
                    ){
                        throw new Exception(
                                "ID can only be UUID compatible string"
                        );
                    }
                    break;
                default:
                    throw new Exception(
                            "No corresponding target"
                    );
            }
        }

    }
}
