package com.spring.employees.test.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.employees.test.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByDepartment_Deptname(String department);
	
	List<Employee> findByJob_Jobid(Integer job_id);
	
	List<Employee> findByEmpnameContaining(String word);
	
	@Query("from Employee where salary between  :min and  :max")
	List<Employee> getBySalaryRange(@Param("min") Double min,@Param("max") Double max);
	
	@Query(value="select * from employee where datediff(year,doj,getdate())>:year",nativeQuery=true)
	List<Employee> getExperienceOfEmpByGivenYears(@Param("year")Integer year);

	
}
