package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    // initialize method is from ConstraintValidator interface
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    // isValid method is from ConstraintValidator interface
    // Validation logic to validate if the course name starts with the value of our annotation value
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result;
        // Handle empty string case
        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }
        else {
            result = true;
        }

        return result;
    }
}






