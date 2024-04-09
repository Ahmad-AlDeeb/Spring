package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;
import java.lang.reflect.Method;

// Implementation For Custom Display Name Generation For Tests
// Resource: https://leeturner.me/post/building-a-camel-case-junit5-displaynamegenerator/

@DisplayNameGeneration(ReplaceCamelCase.class)
public class ReplaceCamelCase extends DisplayNameGenerator.Standard {
    public ReplaceCamelCase() {
    }

    public String generateDisplayNameForClass(Class<?> testClass) {
        return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
    }

    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
    }

    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return this.replaceCapitals(testMethod.getName());
    }

    private String replaceCapitals(String name) {
        name = name.replaceAll("([A-Z])", " $1");
        name = name.replaceAll("([0-9].)", " $1");
        return name;
    }
}