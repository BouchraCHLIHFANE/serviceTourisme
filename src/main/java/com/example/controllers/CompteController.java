package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Compte;
import com.example.repositories.CompteRepository;
import com.example.services.CompteService;

@RestController
@RequestMapping(value = "compte")
public class CompteController {
	
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	CompteService compteService;
   
	@GetMapping(value = "/")
	public List<Compte> findComptesPatient() {
		System.out.println("hello");
		return (List<Compte>) compteRepository.findAll();

	}

}
