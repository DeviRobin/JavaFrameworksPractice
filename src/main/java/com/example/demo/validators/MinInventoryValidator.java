package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinInventoryValidator implements ConstraintValidator<ValidMinInventoryParts, Part> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;
    @Override
    public void initialize(ValidMinInventoryParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) return true;
        if (context != null) myContext = context;
        PartService repo = myContext.getBean(PartServiceImpl.class);
        if ((part.getInv() < part.getMinInv())) {
            return false;
        }
        else {
            return true;
        }
    }

}

