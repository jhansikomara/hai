package com.spring.employees.test.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobhistory")
@IdClass(JobHistory_Pk.class)
public class Job_History {

	@Id
	private Integer jobid;

	@Id
	private Integer empid;

	@Column(name = "Startdate")
	private String startdate;

	@Column(name = "enddate")
	private String enddate;

	//ManytoOne Mapping to Employee
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "empid", insertable = false, updatable = false)
	private Employee employee;

	//ManytoOne Mapping to Job
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "jobid", insertable = false, updatable = false)
	private Job job;

	// Constructor
	public Job_History() {
		super();
	}

	public Job_History(Integer jobid, Integer empid, String startdate, String enddate, Employee employee, Job job) {
		this.jobid = jobid;
		this.empid = empid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.employee = employee;
		this.job = job;
	}

	// Getters and Setters
	public Integer getJobid() {
		return jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	// HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(empid, employee, enddate, job, jobid, startdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job_History other = (Job_History) obj;
		return Objects.equals(empid, other.empid) && Objects.equals(employee, other.employee)
				&& Objects.equals(enddate, other.enddate) && Objects.equals(job, other.job)
				&& Objects.equals(jobid, other.jobid) && Objects.equals(startdate, other.startdate);
	}

	// ToString
	@Override
	public String toString() {
		return "Job_History [jobid=" + jobid + ", empid=" + empid + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", employee=" + employee + ", job=" + job + "]";
	}

}
