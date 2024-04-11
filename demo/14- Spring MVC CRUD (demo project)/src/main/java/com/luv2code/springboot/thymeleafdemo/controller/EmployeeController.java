package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}



	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// Get the employees from DB
		List<Employee> theEmployees = employeeService.findAll();

		// Add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// Create model attribute to bind form data
		Employee theEmployee = new Employee();

		// Add to the spring model
		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}


	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// Save the employee
		employeeService.save(theEmployee);

		// Use a redirect to another endpoint to prevent duplicate submissions
		return "redirect:/employees/list";
	}


	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {

		// Get the employee from the service
		Employee theEmployee = employeeService.findById(theId);

		// Set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);

		// Send over to our form
		return "employees/employee-form";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// Delete the employee
		employeeService.deleteById(theId);

		// Redirect to /employees/list
		return "redirect:/employees/list";

	}
}









