package com.spring.employees.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.employees.test.entities.Job;
import com.spring.employees.test.repos.JobRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class JobController {

	@Autowired
	JobRepo jr;

	// Displaying the list of jobs.
	@GetMapping("/getjobs")
	@Operation(summary = "Get Job details", description = "Job entity gives all jobs data")
	public List<Job> getJobs() {
		var jobs = jr.findAll();
		if (jobs.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid jobs");
		return jobs;

	}

}
