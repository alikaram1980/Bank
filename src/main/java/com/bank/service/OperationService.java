package com.bank.service;

import com.bank.entity.PageOperation;

public interface OperationService {
	
	public boolean pay(String code, double amount, long codeEmp);
	public boolean remove(String code, double amount, long codeEmp);
	public boolean transfer (String cpte1, String cpte2, double amount,long codeEmp);
	public PageOperation getOperations(String codeAccount,int page, int size);
	

}
