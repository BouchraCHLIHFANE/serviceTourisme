package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Compte;
import com.example.repositories.CompteRepository;
import com.example.services.CompteService;
@RestController
@RequestMapping(value = "comptes")

public class CompteController {

	@Autowired
	private CompteService compteService;
	@Autowired
	private CompteRepository compteRepository;
	
	
	@GetMapping(value="/")
	public List<Compte> listeDesComptes(){
		return (List<Compte>) compteRepository.findAll();
	}
	
	@GetMapping(value =  "/add")
	public ModelAndView addStudents(ModelAndView mv) {
		mv.addObject("pageTitle", "Students | Add");
		mv.addObject("comptesListes", (List<Compte>) compteRepository.findAll());
		mv.setViewName("listeComptes");
		return mv;
	} 
}
