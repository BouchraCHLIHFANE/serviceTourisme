package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Personne;
import com.example.repositories.PersonneRepository;

@RestController
public class PersonneController {

	@Autowired
	PersonneRepository personneRepository;

	@GetMapping(value = "/personne")
	public List<Personne> listePersonne() {
		return (List<Personne>) personneRepository.findAll();
	}
}
