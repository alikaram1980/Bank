package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.EmployeeRepository;
import com.bank.entity.Employee;
@Service 
public class EmployeeServiceImpl  implements EmployeeService{
@Autowired
 private EmployeeRepository employeeRepository;

@Override
public Employee saveEmployee(Employee e) {
	// TODO Auto-generated method stub
	return employeeRepository.save(e);
}

@Override
public List<Employee> listEmployees() {
	// TODO Auto-generated method stub
	return employeeRepository.findAll();
}
	

}
