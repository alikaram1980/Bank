package com.bank.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Employee implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeEmployee;
	private String nameEmployee;
	@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")
	private Employee employeeSup;
	 @ManyToMany
	 @JoinTable(name="EMP_GR")
	private Collection<Group>groups;
	public long getCodeEmployee() {
		return codeEmployee;
	}
	public void setCodeEmployee(long codeEmployee) {
		this.codeEmployee = codeEmployee;
	}
	public String getNameEmployee() {
		return nameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	public Employee getEmployeeSup() {
		return employeeSup;
	}
	public void setEmployeeSup(Employee employeeSup) {
		this.employeeSup = employeeSup;
	}
	public Collection<Group> getGroups() {
		return groups;
	}
	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String nameEmployee) {
		super();
		this.nameEmployee = nameEmployee;
	}
	

}
