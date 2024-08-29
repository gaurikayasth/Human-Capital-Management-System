package com.example.HumanCapitalManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int skillId;
	String skillName;
	String skillVersion;
	String skillLevel;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "emp_id", nullable = false)
	Employee employee;
	
	public Skill() {
		// TODO Auto-generated constructor stub
	}

	public Skill(int skillId, String skillName, String skillVersion, String skillLevel, Employee employee) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillVersion = skillVersion;
		this.skillLevel = skillLevel;
		this.employee = employee;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillVersion() {
		return skillVersion;
	}

	public void setSkillVersion(String skillVersion) {
		this.skillVersion = skillVersion;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
