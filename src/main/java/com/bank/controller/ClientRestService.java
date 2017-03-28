package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Client;
import com.bank.service.ClientServiceImpl;

@RestController
public class ClientRestService {
	
	@Autowired
	ClientServiceImpl clientServiceImpl;
	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client c) {
		return clientServiceImpl.saveClient(c);
	}
	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientServiceImpl.listClient();
	}

}
