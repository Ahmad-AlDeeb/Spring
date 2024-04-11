package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Methods return HTML pages while in @RestController methods return Strings
@Controller
public class FormController {

    // Controller method to render form.html
    @GetMapping("/form")
    public String getForm() {
        return "form";
    }


    /* Controller method to:
        1- Read form data from request (another approach: use @RequestParam)
        2- Add data to the model
        3- Render form results */
    @PostMapping("/result")
    public String getResult(HttpServletRequest request, Model model) {
        // Read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // Convert the data to all caps
        theName = theName.toUpperCase();

        // Create the message
        String result = "Yo! " + theName;

        // Add message to the model
        model.addAttribute("message", result);
        return "result";
    }
}








