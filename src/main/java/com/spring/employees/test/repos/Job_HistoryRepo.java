package com.spring.employees.test.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employees.test.entities.JobHistory_Pk;
import com.spring.employees.test.entities.Job_History;

public interface Job_HistoryRepo extends JpaRepository<Job_History, JobHistory_Pk> {
	List<Job_History> findByEmployee_Empid(Integer empid);
}
