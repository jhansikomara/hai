package com.spring.employees.test.entities;

import java.io.Serializable;
import java.util.Objects;

public class JobHistory_Pk implements Serializable {

	private Integer jobid;

	private Integer empid;

	public JobHistory_Pk() {

	}

	// Constructor
	public JobHistory_Pk(Integer jobid, Integer empid) {
		this.jobid = jobid;
		this.empid = empid;
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

	// HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(empid, jobid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobHistory_Pk other = (JobHistory_Pk) obj;
		return Objects.equals(empid, other.empid) && Objects.equals(jobid, other.jobid);
	}

	// ToString
	@Override
	public String toString() {
		return "JobHistory_Pk [jobid=" + jobid + ", empid=" + empid + "]";
	}

}
