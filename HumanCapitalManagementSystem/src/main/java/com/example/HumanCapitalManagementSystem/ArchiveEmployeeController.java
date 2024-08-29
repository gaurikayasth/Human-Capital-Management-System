package com.example.HumanCapitalManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HumanCapitalManagementSystem.entity.ArchiveEmployee;
import com.example.HumanCapitalManagementSystem.repository.archiveEmployeeRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class ArchiveEmployeeController {

	@Autowired
	archiveEmployeeRepository arEmpRepo;
	
	@GetMapping("/archive/employee")
	public List<ArchiveEmployee> getEmployee()
	{
		return (List<ArchiveEmployee>) arEmpRepo.findAll();
	}
}
