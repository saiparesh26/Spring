package com.sp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sp.pma.dao.EmployeeRepository;
import com.sp.pma.dao.ProjectRepository;
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
	public String displayHome(Model model) {
		// We are querying the database for projects
		List<Project> projects =  proRepo.findAll();
		model.addAttribute("projects", projects);

		// We are querying the database for employees
		List<EmployeeProject> employeesProjectCount =  empRepo.employeeProjects();		
		model.addAttribute("employeesListProjectCount", employeesProjectCount);
		return "main/home";
	}
}
