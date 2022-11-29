package com.example.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.model.Client;
import com.example.crm.service.ClientDirectory;

@RestController
@RequestMapping("api")
public class ClientController {

	@Autowired
	private ClientDirectory clientDirectory;

	@GetMapping("clients")
	public List<Client> getClients() {
		return clientDirectory.getClients();
	}

	@GetMapping("clients/{id}")
	public ResponseEntity<Client> getClientsById(@PathVariable("id") Long id) {
		Optional<Client> optionalClient = clientDirectory.getClientById(id);
		if (optionalClient.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalClient.get());
		}
	}
	
	@PostMapping("clients")
	public Client postClient(@RequestBody Client newClient) {
		clientDirectory.addClient(newClient);
		return newClient;
	}
	
	@DeleteMapping("clients/{id}")
	public void deleteClient(@PathVariable("id") Long id) {
		clientDirectory.deleteClient(id);
	}
	
	@PutMapping("clients/{id}")
	public  ResponseEntity<Client> updateClient(@RequestBody Client varClient,  @PathVariable("id") Long id){
		if(!varClient.getId().equals(id)) {
			return ResponseEntity.badRequest().build();
		}
		else {
			clientDirectory.updateClient(varClient, id);
			return ResponseEntity.ok().build();
		}
	}

}
