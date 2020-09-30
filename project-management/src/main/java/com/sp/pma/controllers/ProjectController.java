package com.sp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.pma.dao.ProjectRepository;
import com.sp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@RequestMapping("/new")
	public String displayProjectForm (Model model) {
		model.addAttribute("project", new Project() );
		return "new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		// This method should handle saving into the database
		proRepo.save(project);
		
		//use a redirect to prevent duplicate submission
		return "redirect:/projects/new";
	}
}
