package com.spring.employees.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.employees.test.entities.JobHistory_Pk;
import com.spring.employees.test.entities.Job_History;
import com.spring.employees.test.repos.Job_HistoryRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class JobHistory_Controller {

	@Autowired
	Job_HistoryRepo jhr;

	// Displaying the list of job history for given employee.
	@GetMapping("/getJobHistory/{empid}")
	@Operation(summary = "Get Job History by Jobs ", description = "Getting job history by using emp id ")
	public List<Job_History> getJobHistory(@PathVariable Integer empid) {
		var jobHistory = jhr.findByEmployee_Empid(empid);
		if (jobHistory.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " DATA NOT FOUND ");
		else
			return jobHistory;

	}

	// Displaying the added new job history by taking job id, emp id,start date and
	// end date.
	@PostMapping("/insert")
	@Operation(summary = "Insert the Job History", description = "Insertin@Operation(summary = \"Insert the Job History\", description = \"Inserting the new data into job history\")g the new data into job history")
	public Job_History addjobhistory(@RequestBody Job_History history) {
		try {
			jhr.save(history);
			return history;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.IM_USED, "DATA IS ALREADY PRESENT");
		}
	}

	
	//Finding start date and end date of an employee
	@GetMapping("/get/startDate/endDate/{eid}/{jid}")
	@Operation(summary = "Get start date and end date of an employee ", description = "Getting starting date and ending date of an employee by using emp id and dept id ")
	public Job_History getDetails(@PathVariable int empid,@PathVariable int jobid) {
		return jhr.findById(new JobHistory_Pk(jobid,empid)).get();
		
	}
	
}
