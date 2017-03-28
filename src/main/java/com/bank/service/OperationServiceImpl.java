package com.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.AccountRepository;
import com.bank.dao.EmployeeRepository;
import com.bank.dao.OperationRepository;
import com.bank.entity.Account;
import com.bank.entity.Employee;
import com.bank.entity.Operation;
import com.bank.entity.PageOperation;
import com.bank.entity.Payment;
import com.bank.entity.Withdrawal;

@Service
public class OperationServiceImpl implements OperationService{
	
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	@Transactional
	public boolean pay(String code, double amount, long codeEmp) {
		Account cp = accountRepository.findOne(code);
		Employee emp = employeeRepository.findOne(codeEmp);
		Operation op = new Payment();
		op.setDateOperation(new Date());
		op.setAmount(amount);
		op.setEmployee(emp);
		operationRepository.save(op);
		cp.setBalance(cp.getBalance()+amount);
		return true;
	}

	@Override
	@Transactional
	public boolean remove(String code, double amount, long codeEmp) {
		Account cp = accountRepository.findOne(code);
		if(cp.getBalance()< amount)throw new RuntimeException("Balance insufecient");
		Employee emp = employeeRepository.findOne(codeEmp);
		Operation op = new Withdrawal();
		op.setDateOperation(new Date());
		op.setAmount(amount);
		op.setEmployee(emp);
		operationRepository.save(op);
		cp.setBalance(cp.getBalance()-amount);
		return true;
	}

	@Override
	@Transactional
	public boolean transfer(String cpte1, String cpte2, double amount, long codeEmp) {
		remove(cpte1,amount,codeEmp);
		pay(cpte2,amount,codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeAccount, int page, int size) {
		Page<Operation> ops = operationRepository.getOperations(codeAccount, new PageRequest(page , size));
		
		List<Operation> op2 = operationRepository.getOneValue(codeAccount);	
		//Account cp = accountRepository.findOne(codeAccount);
		
		//Page<Operation> op2 = operationRepository.findByAccount(cp, pageable);
		
		PageOperation pOp	= new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNumberOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperations((int)ops.getTotalElements());
		return pOp;
	}

}
