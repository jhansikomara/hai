package com.spring.employees.test.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	private String deptid;

	private String deptname;

	private Integer empidhod;

	//OnetoMany Mapping to Employee
	@OneToMany(mappedBy = "department")
	@JsonIgnore
	private List<Employee> employee = new ArrayList<Employee>();

	// Getters and Setters
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptid() {
		return deptid;
	}

	public String getEmpname() {
		return deptname;
	}

	public void setEmpname(String deptname) {
		this.deptname = deptname;
	}

	public Integer getEmpidhod() {
		return empidhod;
	}

	public void setEmpidhod(Integer empidhod) {
		this.empidhod = empidhod;
	}

	// HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(deptid, empidhod, deptname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(deptid, other.deptid) && Objects.equals(empidhod, other.empidhod)
				&& Objects.equals(deptname, other.deptname);
	}

	// ToString
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname + ", empid=" + empidhod + "]";
	}

}
