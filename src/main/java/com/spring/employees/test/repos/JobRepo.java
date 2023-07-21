package com.spring.employees.test.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employees.test.entities.Job;

public interface JobRepo extends JpaRepository<Job, Integer>{

}
