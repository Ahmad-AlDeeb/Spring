package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    /** Injecting values from application.properties **/
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;


    @GetMapping("/form")
    public String getForm(Model theModel) {

        // add student object to the model
        theModel.addAttribute("student", new Student());

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // add the list of languages to the model
        theModel.addAttribute("languages", languages);

        // add the list of systems to the model
        theModel.addAttribute("systems", systems);

        // Render form.html
        return "form";
    }

    @PostMapping("/result")
    public String getResult(@ModelAttribute("student") Student theStudent) {
        // Render result.html
        return "result";
    }
}








