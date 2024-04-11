package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // @InitBinder pre-process web request to controller
    // Used to remove leading and trailing whitespace from every String in request to the controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/form")
    public String getForm(Model theModel) {

        // Adding object to the model for HTML to use
        theModel.addAttribute("customer", new Customer());

        return "form";
    }

    @PostMapping("/result")
    public String getResult(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {

        // ========== Debugging Binding Results ==========
        // System.out.println("Binding results: " + theBindingResult.toString());
        // System.out.println("\n\n\n\n");

        // Go to result if there are no errors, otherwise, go to form again
        if (theBindingResult.hasErrors()) {
            return "form";
        }
        else {
            return "result";
        }
    }
}







