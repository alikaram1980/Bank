package com.bank.service;

import java.util.List;

import com.bank.entity.Client;

public interface ClientService {

	public Client saveClient (Client c);
	public List<Client> listClient();
}
