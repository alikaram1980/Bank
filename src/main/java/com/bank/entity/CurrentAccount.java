package com.bank.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CC")
@XmlType(name="CC")
public class CurrentAccount extends Account {

	private double discovered;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(String accountCode, Date creationDate, double balance, double discovered) {
		super(accountCode, creationDate, balance);
		this.discovered = discovered;
	}

	public double getDiscovered() {
		return discovered;
	}

	public void setDiscovered(double discovered) {
		this.discovered = discovered;
	}
	
}
