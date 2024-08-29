package com.example.HumanCapitalManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.HumanCapitalManagementSystem.entity.Department;
import com.example.HumanCapitalManagementSystem.entity.Employee;

public interface employeeRepository extends CrudRepository<Employee, Integer>{
	public List<Employee> findByDepartment(Department department);//derived query
	public Employee findByEmailAndPassword(String email,String password);
	
	@Query(value="select * from employee where emp_name like ?1", nativeQuery = true)
	public List<Employee> findByEmployeeNameLike(String empName);
	
}
