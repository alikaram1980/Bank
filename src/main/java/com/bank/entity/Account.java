package com.bank.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CCOUNT", discriminatorType=DiscriminatorType.STRING,length=2)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@Type(name="CC",value=CurrentAccount.class),
	@Type(name="CE",value=SavingsAccount.class)
	
})


@XmlSeeAlso({CurrentAccount.class,SavingsAccount.class})
public abstract class Account implements Serializable {
 @Id
 private String accountCode;
 private Date creationDate;
 private double balance;
 @ManyToOne
 @JoinColumn(name="CODE_CLI")
 private Client client;
 @ManyToOne
 @JoinColumn(name="CODE_EMP")
 private Employee employee;
 @OneToMany(mappedBy="account",fetch=FetchType.LAZY)
 private Collection<Operation> operations;
public String getAccountCode() {
	return accountCode;
}
public void setAccountCode(String accountCode) {
	this.accountCode = accountCode;
}
public Date getCreationDate() {
	return creationDate;
}
public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
@XmlTransient
public Collection<Operation> getOperations() {
	return operations;
}
public void setOperations(Collection<Operation> operations) {
	this.operations = operations;
}
public Account() {
	super();
	// TODO Auto-generated constructor stub
}
public Account(String accountCode, Date creationDate, double balance) {
	super();
	this.accountCode = accountCode;
	this.creationDate = creationDate;
	this.balance = balance;
}
}
