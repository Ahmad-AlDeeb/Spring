package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

// To change default endpoints from "employees" to "members"
// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// That's it ... no need to write any code for CRUD!

    // Add a method to sort by last name
    // Spring Data JPA will implement it by detecting its pattern from its name
    public List<Employee> findAllByOrderByLastNameAsc();

}
