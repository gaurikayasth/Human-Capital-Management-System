package com.example.HumanCapitalManagementSystem.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="archiveEmployee")
public class ArchiveEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int empId;
	String empName;
	String empPhone;
	String email;
	String empAddress;
	String empGender;
	double empSalary;
	String password;
	@JsonFormat(pattern="dd-MM-yyyy")
	Date dateOfJoining;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dept_id", nullable = false)
	Department department;
	
	public ArchiveEmployee() {
		// TODO Auto-generated constructor stub
	}

	public ArchiveEmployee(int empId, String empName, String empPhone, String email, String empAddress, String empGender,
			double empSalary, String password, Date dateOfJoining, Department department) {
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
		this.email = email;
		this.empAddress = empAddress;
		this.empGender = empGender;
		this.empSalary = empSalary;
		this.password = password;
		this.dateOfJoining = dateOfJoining;
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
