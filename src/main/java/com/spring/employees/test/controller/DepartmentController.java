package com.spring.employees.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.employees.test.entities.Department;
import com.spring.employees.test.repos.DepartmentRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepo dr;

	// Displaying the list of departments.
	@GetMapping("/getdepartment")
	@Operation(summary = "Get Departments", description = "Department Entity gives all data")
	public List<Department> getdepartment() {
		var dept = dr.findAll();
		if (dept.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no data found");
		else
			return dept;
	}
	


}
