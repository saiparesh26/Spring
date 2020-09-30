package com.sp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.sp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}
