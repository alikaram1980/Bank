package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Employee;
import com.bank.service.EmployeeServiceImpl;

@RestController
public class EmployeeRestService {
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	@RequestMapping(value="/employees",method=RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee e) {
		return employeeServiceImpl.saveEmployee(e);
	}
	@RequestMapping(value="/employees",method=RequestMethod.GET)
	public List<Employee> listEmployees() {
		return employeeServiceImpl.listEmployees();
	}
	

}
