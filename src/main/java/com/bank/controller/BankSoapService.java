package com.bank.controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.dao.AccountRepository;
import com.bank.dao.OperationRepository;
import com.bank.entity.Account;
import com.bank.entity.PageOperation;
import com.bank.service.AccountService;
import com.bank.service.OperationService;
@Component
@WebService
public class BankSoapService {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OperationService operationService;
	
	@WebMethod
	public Account getAccount(@WebParam(name="code")String code) {
		return accountService.getAccount(code);
	}
	@WebMethod
	public boolean pay(
			@WebParam(name="code")String code,
			@WebParam(name="amount")double amount,
			@WebParam(name ="codeEmp")long codeEmp) {
		return operationService.pay(code, amount, codeEmp);
	}
	@WebMethod
	public boolean remove(
			@WebParam(name="code")String code, 
			@WebParam(name="amount")double amount,
			@WebParam(name="codeEmp")long codeEmp) {
		return operationService.remove(code, amount, codeEmp);
	}
	
	@WebMethod
	public boolean transfer(
			@WebParam(name="cpte1")String cpte1,
			@WebParam(name="cpte2")String cpte2,
			@WebParam(name="amount")double amount,
			@WebParam (name="codeEmp")long codeEmp) {
		return operationService.transfer(cpte1, cpte2, amount, codeEmp);
	}
	
	@WebMethod
	public PageOperation getOperations(
			@WebParam(name="codeAccount")String codeAccount,
			@WebParam(name="page")int page,
			@WebParam(name="size")int size) {
		return operationService.getOperations(codeAccount, page, size);
	}
	
	
	

}
