package com.brasilprev.test.brasilprevtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brasilprev.test.brasilprevtest.model.Client;
import com.brasilprev.test.brasilprevtest.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> listClient() {
		return clientRepository.findAll(); 
	}
	
	public Client clientById(Long id) {
		return clientRepository.findById(id).get(); 
	}
	
	public Client saveClient(Client client) { 
		return clientRepository.save(client);
	}
	
	public ResponseEntity<Client> updateClient(Client client, Long id) {
		boolean validId = clientRepository.existsById(id);
		if(validId) {
			client.setId(id);
			Client updatedClient = clientRepository.saveAndFlush(client);
			return new ResponseEntity<Client>(updatedClient, HttpStatus.OK);
		}else {
			return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
		}
	}
	
	public void deleteClient(Long id){
		clientRepository.deleteById(id);
	}
}
