package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {MinInventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMinInventoryParts {
    String message() default "Inventory is less than Minimum Inventory parameter. Please increase inventory accordingly. ";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}



