package com.bank.service;

import java.util.List;

import com.bank.entity.Employee;

public interface EmployeeService {
 public Employee saveEmployee (Employee e);
 public List<Employee> listEmployees();
}