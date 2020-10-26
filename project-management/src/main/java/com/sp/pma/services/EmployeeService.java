package com.sp.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sp.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {
	
	// 1st way - Field Injection
	@Autowired
	EmployeeRepository empRepo;
	
	IStaffRepository staffRepo;
	
	public EmployeeService(@Qualifier("StaffRepositoryImpl2")  IStaffRepository staffRepo) {
		this.staffRepo =staffRepo;	
	}
	
	// 2nd way - Constructor Injection
//	public EmployeeService(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;		
//	}
	
	// 3rd way - Setter Injection
//	@Autowired
//	public void setEmployeeRepository(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}
}
