package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Employee;


public interface EmployeeRepository extends JpaRepository <Employee,Long>{

}
