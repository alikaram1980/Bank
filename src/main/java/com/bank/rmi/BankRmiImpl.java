package com.bank.rmi;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.entity.Account;
import com.bank.service.AccountService;
import com.bank.service.OperationService;
@Component("MyRmiService")
public class BankRmiImpl  implements BankRmiRemote{
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private OperationService operationService;
	

	@Override
	public Account saveAccount(Account cp) throws RemoteException {
		
		return accountService.saveAccount(cp);
	}

	@Override
	public Account getAccount(String code) throws RemoteException {
		
		return accountService.getAccount(code);
	}

	@Override
	public boolean pay(String code, double amount, long codeEmp) throws RemoteException {
		
		return operationService.pay(code, amount, codeEmp);
	}

	@Override
	public boolean remove(String code, double amount, long codeEmp) throws RemoteException {
		
		return operationService.remove(code, amount, codeEmp);
	}

	@Override
	public boolean transfer(String cpte1, String cpte2, double amount, long codeEmp) throws RemoteException {
		
		return operationService.transfer(cpte1, cpte2, amount, codeEmp);
	}

}
