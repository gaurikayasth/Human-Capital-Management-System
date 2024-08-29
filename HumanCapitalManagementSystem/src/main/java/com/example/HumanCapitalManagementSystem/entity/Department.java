package com.example.HumanCapitalManagementSystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int deptId;
	String deptName;
	String deptHead;
	int noOfEmployees;
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	List<Employee> employees;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	List<ArchiveEmployee> archivedEmployees;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int deptId, String deptName, String deptHead, int noOfEmployees, List<Employee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptHead = deptHead;
		this.noOfEmployees = noOfEmployees;
		this.employees = employees;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<ArchiveEmployee> getArchivedEmployees() {
		return archivedEmployees;
	}

	public void setArchivedEmployees(List<ArchiveEmployee> archivedEmployees) {
		this.archivedEmployees = archivedEmployees;
	}
	
}
