package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.PageOperation;
import com.bank.service.OperationServiceImpl;

@RestController
public class OperationRestService {
	@Autowired
	OperationServiceImpl operationServiceImpl;
	
	
	
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperations(
			@RequestParam String codeAccount,
			@RequestParam int page,
			@RequestParam int size) {
		return operationServiceImpl.getOperations(codeAccount, page, size);
	}
	
	
	@RequestMapping(value="/payment",method=RequestMethod.PUT)
	public boolean pay(
			@RequestParam String code,
			@RequestParam double amount,
			@RequestParam long codeEmp) {
		return operationServiceImpl.pay(code, amount, codeEmp);
	}
	@RequestMapping(value="/withdraw",method=RequestMethod.PUT)
	public boolean remove(
			@RequestParam String code,
			@RequestParam double amount,
			@RequestParam long codeEmp) {
		return operationServiceImpl.remove(code, amount, codeEmp);
	}
	@RequestMapping(value="/transfer",method=RequestMethod.PUT)
	public boolean transfer(
			@RequestParam String cpte1,
			@RequestParam String cpte2,
			@RequestParam double amount,
			@RequestParam long codeEmp) {
		return operationServiceImpl.transfer(cpte1, cpte2, amount, codeEmp);
	}

}
