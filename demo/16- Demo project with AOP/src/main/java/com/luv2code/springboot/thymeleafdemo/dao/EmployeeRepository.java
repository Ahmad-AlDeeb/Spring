package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

// To change default endpoints from "employees" to "members"
// @RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // That's it ... thanks to JpaRepository, no need to write any code for CRUD!
    //
    //
    //
    /* Add a method to sort by last name
    * Behind the scenes, Spring Data JPA will:
    *   1- Parse the method name
    *   2- Looks for a specific format and pattern
    *   3- Creates appropriate query
     */
    public List<Employee> findAllByOrderByLastNameAsc();

}
