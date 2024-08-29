package com.example.HumanCapitalManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanCapitalManagementSystem.entity.Department;
import com.example.HumanCapitalManagementSystem.repository.departmentRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class departmentController {

	@Autowired
	departmentRepository deptRepo;
	
	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department dept)
	{
		return deptRepo.save(dept);
	}
	
	@GetMapping("/department")
	public List<Department> getDepartment()
	{
		return (List<Department>) deptRepo.findAll();
	}
	
	@PutMapping("/department")
	public Department editEmployee(@RequestBody Department dept)
	{
		return deptRepo.save(dept);
	}
	
	@DeleteMapping("/department/{departmentId}")
	public String deleteDepartment(@PathVariable int departmentId)
	{
		try {
			deptRepo.deleteById(departmentId);
			return "OK";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "NOT_OK";
		}
	}
	
	@GetMapping("/department/departments/{departmentName}")
	public Department getEmployeeByDepartment(@PathVariable String departmentName)
	{
		Department department = new Department();
		department.setDeptName(departmentName);
		return deptRepo.findByDeptName(department);
	}
}
