package com.spring.employees.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.employees.test.entities.Employee;
import com.spring.employees.test.repos.EmployeeRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo er;

	// Displaying the list of employees by jobs.
	@GetMapping("/getEmpByJob/{jobid}")
	@Operation(summary = "Get Employees by job", description = "Getting employees by using job id")
	public List<Employee> getEmployeeByJob(@PathVariable("jobid") Integer jobid) {
		var employees = er.findByJob_Jobid(jobid);
		if (employees.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO DATA FOUND");
		else
			return employees;
	}

	// Displaying the list of employees by department.
	@GetMapping("/getEmpbyDept/{deptname}")
	@Operation(summary = "Get Employees By dept", description = "Getting Employees details by using dept")
	public List<Employee> getEmployeeByDepartment(@PathVariable("deptname") String deptname) {
		var employees = er.findByDepartment_Deptname(deptname);
		if (employees.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO DATA FOUND");
		else
			return employees;

	}

	// Displaying the list of employees where name contains a given string.
	@GetMapping("/getEmpContainWord/{word}")
	@Operation(summary = "Get Employees Of a Given String", description = "Getting All Employees by using given String")
	public List<Employee> getEmployeeContainString(@PathVariable("word") String word) {
		var employee = er.findByEmpnameContaining(word);
		if (employee.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO DATA FOUND");
		else
			return employee;

	}

	// Displaying the list of employees by given salary range.
	@GetMapping("/getEmpBySalaryRange")
	@Operation(summary = "Get Employees By given Salary Range", description = "Getting all employees by given salary range")
	public List<Employee> getEmployeeBySalaryRange(@RequestParam Double min, @RequestParam Double max) {
		var employees = er.getBySalaryRange(min, max);
		if (employees.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO DATA FOUND");
		else
			return employees;

	}

	// Displaying the list of employees having experience greater than given years.
	@GetMapping("/getEmployeeExperience/{year}")
	@Operation(summary = "Get Experience Employees By Given years", description = "Getting experience employees by given years")
	public List<Employee> getemployeeExperience(@PathVariable("year") Integer year) {
		var emp = er.getExperienceOfEmpByGivenYears(year);
		if (emp.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NO DATA FOUND");
		else
			return emp;

	}

	// Displaying the update salary of employee.
	@PutMapping("/updateSalary/{empid}/{salary}")
	@Operation(summary = "Update Salary Of an Employee", description = "Updating Salary of an employee by emp id and given salary")
	public Employee updateSalary(@PathVariable Integer empid, @PathVariable Double salary) {
		var employee = er.findById(empid);
		if (employee.isPresent()) {
			var e = employee.get();
			e.setSalary(salary);
			er.save(e);
			return e;

		} else 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID EMPLOYEE ID");
		
	}
	
	//Finding DOJ of an employee
	@GetMapping("/getdojByEmployee/{empid}")
	
	public Employee getdojByEmployee(@PathVariable("empid") Integer empid) {
		var emp = er.findById(empid);
		if (emp.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO DATA FOUND");
		else
			return emp.get();
	}
	
	// Displaying the list of employees.
		@GetMapping("/getemployees")
		@Operation(summary = "Get Employees", description = "Employee Entity gives all data")
		public List<Employee> getemployees() {
			var emp = er.findAll();
			if (emp.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no data found");
			else
				return emp;
		}


}
