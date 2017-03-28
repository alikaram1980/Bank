package com.bank.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CE")
@XmlType(name="CE")

public class SavingsAccount extends Account{
	
	private double rate;

	public SavingsAccount() {
		super();
		
	}

	public SavingsAccount(String accountCode, Date creationDate, double balance, double rate) {
		super(accountCode, creationDate, balance);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
