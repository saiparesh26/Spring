package com.sp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.pma.dao.EmployeeRepository;
import com.sp.pma.dao.ProjectRepository;
import com.sp.pma.dto.ChartData;
import com.sp.pma.dto.EmployeeProject;
import com.sp.pma.entities.Employee;
import com.sp.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
		
		// We are querying the database for projects
		List<Project> projects =  proRepo.findAll();
		model.addAttribute("projects", projects);

		List<ChartData> projectData = proRepo.getProjectStatus();
		
		// Lets convert projectdata into json structure to be used in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// [ {"NOTSTARTED": 1}, {"INPROGRESS": 2}, {"COMPLETED": 1} ]
		
		model.addAttribute("projectStatusCount", jsonString);
		
		// We are querying the database for employees
		List<EmployeeProject> employeesProjectCount =  empRepo.employeeProjects();		
		model.addAttribute("employeesListProjectCount", employeesProjectCount);
		return "main/home";
	}
}
