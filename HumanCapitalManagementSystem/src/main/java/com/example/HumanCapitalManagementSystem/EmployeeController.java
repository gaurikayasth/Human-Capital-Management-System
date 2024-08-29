package com.example.HumanCapitalManagementSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanCapitalManagementSystem.entity.ArchiveEmployee;
import com.example.HumanCapitalManagementSystem.entity.Department;
import com.example.HumanCapitalManagementSystem.entity.Employee;
import com.example.HumanCapitalManagementSystem.module.Status;
import com.example.HumanCapitalManagementSystem.repository.archiveEmployeeRepository;
import com.example.HumanCapitalManagementSystem.repository.employeeRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {

	@Autowired
	employeeRepository empRepo;
	
	@Autowired
	archiveEmployeeRepository arEmpRepo;
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee emp)
	{
		return empRepo.save(emp);
	}
	
	@PutMapping("/employee")
	public Employee editEmployee(@RequestBody Employee emp)
	{
		return empRepo.save(emp);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployee()
	{
		return (List<Employee>) empRepo.findAll();
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public Status deleteEmployee(@PathVariable int employeeId)
	{
		try {
			Optional<Employee> optional=empRepo.findById(employeeId);
			if(!optional.isPresent())//if false
				return new Status(false);
			
			Employee emp=optional.get();
			empRepo.deleteById(employeeId);
						
			ArchiveEmployee arEmp=new ArchiveEmployee(emp.getEmpId(),emp.getEmpName(),emp.getEmpPhone(),emp.getEmail(),emp.getEmpAddress(),
					emp.getEmpGender(),emp.getEmpSalary(),emp.getPassword(),emp.getDateOfJoining(),emp.getDepartment());
			
			arEmpRepo.save(arEmp);
			return new Status(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new Status(false);
		}
	}
	
//	@PostMapping("/archiveemployee")
//	public ArchiveEmployee saveDeletedEmployee(@RequestBody ArchiveEmployee emp)
//	{
//		return arEmpRepo.save(emp);
//	}
	
	@GetMapping("/employee/departments/{departmentId}")
	public List<Employee> getEmployeeByDepartment(@PathVariable int departmentId)
	{
		Department department = new Department();
		department.setDeptId(departmentId);
		return (List<Employee>)empRepo.findByDepartment(department);
	}
	
	@GetMapping("/employee/find/{employeeName}")
	public List<Employee> getEmployeesByName(@PathVariable String employeeName)
	{
		return empRepo.findByEmployeeNameLike("%" + employeeName + "%");
	}
	
	@PostMapping("/signin")
	public Employee signIn(@RequestBody Employee emp)
	{
		return empRepo.findByEmailAndPassword(emp.getEmail(),emp.getPassword());
	}
}
