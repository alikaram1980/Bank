package com.bank.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Groups")
public class Group implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeEmployee;
	private String nameEmployee;
	@ManyToMany(mappedBy="groups")
	private Collection<Employee>employes;
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
	public Collection<Employee> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employee> employes) {
		this.employes = employes;
	}
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(String nameEmployee) {
		super();
		this.nameEmployee = nameEmployee;
	}
	
	
}
