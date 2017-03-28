package com.bank.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@Type(name="V",value=Payment.class),
	@Type(name="R",value=Withdrawal.class)
})
public class Operation implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numberOperation;
	private Date dateOperation;
	private double amount;
	@ManyToOne
	@JoinColumn(name="CODE_CCOUNT")
	private Account account;
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employee employee;
	public long getNumberOperation() {
		return numberOperation;
	}
	public void setNumberOperation(long numberOperation) {
		this.numberOperation = numberOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@JsonIgnore
	@XmlTransient
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@JsonIgnore
	@XmlTransient
	public Employee getEmployee() {
		return employee;
	}
	@JsonSetter
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double amount) {
		super();
		this.dateOperation = dateOperation;
		this.amount = amount;
	}

}
