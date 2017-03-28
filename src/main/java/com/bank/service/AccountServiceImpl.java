package com.bank.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountRepository;
import com.bank.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired 
	AccountRepository accountRepository;
	@Override
	public Account saveAccount(Account ac) {
		// TODO Auto-generated method stub
		ac.setCreationDate(new Date());
		return accountRepository.save(ac);
	}

	@Override
	public Account getAccount(String code) {
		// TODO Auto-generated method stub
		return accountRepository.findOne(code);
	}

}
