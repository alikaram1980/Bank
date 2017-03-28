package com.bank.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long clientCode;
	private String clientName;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Account>Accounts;
	public Client(String clientName) {
		super();
		this.clientName = clientName;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getClientCode() {
		return clientCode;
	}
	public void setClientCode(long clientCode) {
		this.clientCode = clientCode;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Account> getAccounts() {
		return Accounts;
	}
	public void setAccounts(Collection<Account> accounts) {
		Accounts = accounts;
	}

}
