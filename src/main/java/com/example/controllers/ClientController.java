package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Client;
import com.example.models.Destination;
import com.example.repositories.ClientRepository;


@RestController
@RequestMapping(value = "comptes")
public class ClientController {
	@Autowired
	ClientRepository clientRepository;
	

	@GetMapping(value="/client")
	public Iterable<com.example.models.Client> listeClients(){
		return clientRepository.findAll();
	}
	
	@GetMapping(value="/")
	public String Clients(){
		StringBuffer ch= new StringBuffer();
		List <Client>clients =new ArrayList<Client>();
		clients =(List<Client>) clientRepository.findAll();
		for(Client C: clients) {
			for(Destination D: C.getDestinations()) {
				ch.append(D.getDetails());
			}
		}
		return "";
	}
}
