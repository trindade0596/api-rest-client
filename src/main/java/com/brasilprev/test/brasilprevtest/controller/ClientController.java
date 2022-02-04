package com.brasilprev.test.brasilprevtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brasilprev.test.brasilprevtest.model.Client;
import com.brasilprev.test.brasilprevtest.service.ClientService;


@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	

	@GetMapping
	public List<Client> listClient() {
		return clientService.listClient(); 
	}
	
	@GetMapping("/{id}")
	public Client clientById(@PathVariable Long id) {
		return clientService.clientById(id); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client saveClient(@RequestBody Client client) { 
		return clientService.saveClient(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long id) {
		return clientService.updateClient(client, id);
		
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteClient(@PathVariable Long id){
		clientService.deleteClient(id);
	}
}
