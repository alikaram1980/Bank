package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Client;


public interface ClientRepository extends JpaRepository <Client,Long>{

}
