package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Account;
import com.bank.service.AccountServiceImpl;

@RestController
public class AccountRestService {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@RequestMapping(value="/accounts",method=RequestMethod.POST)
	public Account saveAccount(@RequestBody Account ac) {
		return accountServiceImpl.saveAccount(ac);
	}

	@RequestMapping(value="/accounts/{code}",method=RequestMethod.GET)
	public Account getAccount(@PathVariable String code){
		return accountServiceImpl.getAccount(code);
	}
	

}
