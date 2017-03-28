package com.bank.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.bank.entity.Account;

public interface BankRmiRemote  extends Remote{
	
	public Account saveAccount(Account cp) throws RemoteException;
	public Account getAccount (String code) throws RemoteException;
	public boolean pay(String code, double amount, long codeEmp)throws RemoteException;
	public boolean remove(String code, double amount, long codeEmp)throws RemoteException;
	public boolean transfer (String cpte1, String cpte2, double amount,long codeEmp)throws RemoteException;
}
