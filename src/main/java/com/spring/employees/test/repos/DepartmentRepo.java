package com.spring.employees.test.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employees.test.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, String>{

}
