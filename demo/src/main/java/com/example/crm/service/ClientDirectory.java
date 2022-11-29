package com.example.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crm.dao.ClientRepository;
import com.example.crm.model.Client;

@Service
public class ClientDirectory {

	@Autowired
	private ClientRepository clientRepository;

	public void addClient(Client newClient) {
		clientRepository.save(newClient);
	}

	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	public Optional<Client> getClientById(Long id) {
		return clientRepository.findById(id);
	}

	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

	public void updateClient(Client varClient, Long id) {
//		if(clientRepository.existsById(id))
		clientRepository.save(varClient);
	}

}
