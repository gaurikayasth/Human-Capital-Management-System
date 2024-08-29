package com.example.HumanCapitalManagementSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.HumanCapitalManagementSystem.entity.Department;

public interface departmentRepository extends CrudRepository<Department, Integer>{
	public Department findByDeptName(Department department);
}
