package com.bank.service;

import com.bank.entity.Account;

public interface AccountService {
	public Account saveAccount(Account ac);
	public Account getAccount(String code);
	
}
