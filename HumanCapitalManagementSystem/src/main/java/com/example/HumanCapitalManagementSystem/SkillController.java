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

import com.example.HumanCapitalManagementSystem.entity.Employee;
import com.example.HumanCapitalManagementSystem.entity.Skill;
import com.example.HumanCapitalManagementSystem.repository.skillRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class SkillController {
	
	@Autowired
	skillRepository skillRepo;
	
	@PostMapping("/skill")
	public Skill saveSkill(@RequestBody Skill skill)
	{
		return skillRepo.save(skill);
	}
	
	@GetMapping("/skill")
	public List<Skill> getSkill()
	{
		return (List<Skill>) skillRepo.findAll();
	}
	
	@PutMapping("/skill")
	public Skill editSkill(@RequestBody Skill skill)
	{
		return skillRepo.save(skill);
	}
	
	@DeleteMapping("/skill/{skillId}")
	public String deleteSkill(@PathVariable int skillId)
	{
		try {
			skillRepo.deleteById(skillId);
			return "OK";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "NOT_OK";
		}
	}
	
	
	@GetMapping("/skill/skills/{employeeId}")
	public List<Skill> getSkillsByEmployee(@PathVariable int employeeId)
	{
		Employee employee = new Employee();
		employee.setEmpId(employeeId);
		return (List<Skill>)skillRepo.findByEmployee(employee);
	}
}
