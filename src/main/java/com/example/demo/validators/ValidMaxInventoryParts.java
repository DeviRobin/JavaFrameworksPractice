package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {MaxInventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMaxInventoryParts {
    String message() default "Inventory is greater than Maximum Inventory parameter. Please decrease inventory accordingly. ";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}



