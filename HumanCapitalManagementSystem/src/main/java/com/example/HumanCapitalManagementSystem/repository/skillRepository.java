package com.example.HumanCapitalManagementSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.HumanCapitalManagementSystem.entity.Employee;
import com.example.HumanCapitalManagementSystem.entity.Skill;

public interface skillRepository extends CrudRepository<Skill, Integer>{

	public List<Skill> findByEmployee(Employee employee);

}
