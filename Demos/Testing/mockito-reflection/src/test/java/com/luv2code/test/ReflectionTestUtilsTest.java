package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.model.CollegeStudent;
import com.luv2code.component.model.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes=MvcTestingExampleApplication.class)
public class ReflectionTestUtilsTest {

    ApplicationContext context;
    CollegeStudent studentOne;
    StudentGrades studentGrades;

    @Autowired
    public ReflectionTestUtilsTest(ApplicationContext context, CollegeStudent studentOne, StudentGrades studentGrades) {
        this.context = context;
        this.studentOne = studentOne;
        this.studentGrades = studentGrades;
    }

    @BeforeEach
    public void studentBeforeEach() {
        studentOne.setFirstname("Eric");
        studentOne.setLastname("Roby");
        studentOne.setEmailAddress("eric.roby@luv2code_school.com");
        studentOne.setStudentGrades(studentGrades);

        ReflectionTestUtils.setField(studentOne, "id", 1);
        ReflectionTestUtils.setField(studentOne, "studentGrades",
                new StudentGrades(new ArrayList<>(Arrays.asList(
                        100.0, 85.0, 76.50, 91.75))));
    }

    @Test
    @DisplayName("Test Private Fields")
    public void getPrivateField() {
        assertEquals(1, ReflectionTestUtils.getField(studentOne, "id"));
    }

    @Test
    @DisplayName("Test Private Methods")
    public void invokePrivateMethod() {
        assertEquals("Eric 1",
                ReflectionTestUtils.invokeMethod(studentOne, "getFirstNameAndId"),
                "Fail private method not call");
    }
}
