package com.bank.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entity.Account;
import com.bank.entity.Operation;

public interface OperationRepository extends JpaRepository <Operation,Long> {

	//@Query("select o from Operation o where o.account.accountCode=:x")
	//public Page<Operation> getOperations(@Param("x") String code,Pageable pageable);
	
	//public Page<Operation> findByAccount (Account cp, Pageable pageable);
	
	@Query("select o from Operation o where o.account.accountCode=:x")
	public Page<Operation> getOperations(@Param("x") String code ,Pageable pageable);
	
	@Query("select o from Operation o where o.account.accountCode=:x")
	public  List< Operation> getOneValue(@Param("x") String codeAccount);
}

