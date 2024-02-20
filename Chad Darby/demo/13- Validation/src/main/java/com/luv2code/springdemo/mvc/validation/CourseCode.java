package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the validation class which our annotation will use to validate
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// Define on which elements which our annotation can be used with (e.g. methods, fields)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // Define default course code
    public String value() default "LUV";

    // Define default error message
    public String message() default "must start with LUV";

    // Define default groups (to group related constraints)
    public Class<?>[] groups() default {};

    // Define default payloads
    // (provide custom details about validation failure e.g. severity level, error code, etc...)
    public Class<? extends Payload>[] payload() default {};
}




