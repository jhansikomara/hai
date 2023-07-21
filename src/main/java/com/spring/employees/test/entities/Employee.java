package com.spring.employees.test.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String empname;
	@Column(insertable = false,updatable = false)
	private Integer jobid;
	@Column(insertable = false,updatable = false)
	private String deptid;
	
	private Double salary;
	@Column(name = "doj")
	private String date_of_joining;

	//ManytoOne Mapping to Job
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "jobid")
	private Job job;

	//ManytoOne Mapping to Department
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "deptid")
	private Department department;

	//OnetoMany Mapping to Job_History
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Job_History> jobhistory = new ArrayList<Job_History>();

	// Getters and Setters
	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Integer getJobid() {
		return jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Job_History> getJobhistory() {
		return jobhistory;
	}

	public void setJobhistory(List<Job_History> jobhistory) {
		this.jobhistory = jobhistory;
	}
	// HashCode and Equals
	
	@Override
	public int hashCode() {
		return Objects.hash(date_of_joining, department, deptid, empid, empname, job, jobhistory, jobid, salary);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(date_of_joining, other.date_of_joining) && Objects.equals(department, other.department)
				&& Objects.equals(deptid, other.deptid) && Objects.equals(empid, other.empid)
				&& Objects.equals(empname, other.empname) && Objects.equals(job, other.job)
				&& Objects.equals(jobhistory, other.jobhistory) && Objects.equals(jobid, other.jobid)
				&& Objects.equals(salary, other.salary);
	}

	// ToString
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", jobid=" + jobid + ", deptid=" + deptid
				+ ", salary=" + salary + ", date_of_joining=" + date_of_joining + ", job=" + job + ", department="
				+ department + ", jobhistory=" + jobhistory + "]";
	}

}
