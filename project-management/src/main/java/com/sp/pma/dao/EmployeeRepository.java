package com.sp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.sp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
