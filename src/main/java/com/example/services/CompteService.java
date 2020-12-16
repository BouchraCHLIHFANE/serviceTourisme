package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.CompteRepository;

@Service
public class CompteService {
	@Autowired
    CompteRepository compteRepository;
}
