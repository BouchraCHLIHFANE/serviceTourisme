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
@RequestMapping(value = "client")
public class ClientController {
	@Autowired
	ClientRepository clientRepository;
	

	@GetMapping(value="/")
	public Iterable<com.example.models.Client> listeClients(){
		return clientRepository.findAll();
	}
	
	
}
