package com.spring.employees.test.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobid")
	private Integer jobid;

	@Column(name = "jobtitle")
	private String jobTitle;

	//OnetoMany Mapping to Employee 
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Employee> employee = new ArrayList<Employee>();

	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Job_History> jobhistory = new ArrayList<Job_History>();

	// Getters and Setters
	public Integer getJobid() {
		return jobid;
	}

	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
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
		return Objects.hash(employee, jobTitle, jobhistory, jobid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(jobTitle, other.jobTitle)
				&& Objects.equals(jobhistory, other.jobhistory) && Objects.equals(jobid, other.jobid);
	}

	// ToString
	@Override
	public String toString() {
		return "Job [jobid=" + jobid + ", jobTitle=" + jobTitle + ", employee=" + employee + ", jobhistory="
				+ jobhistory + "]";
	}
}
