package com.example.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView listComptes(ModelAndView mv) {
		mv.addObject("pageTitle", "Students | Add");
		mv.addObject("comptesListes", (List<Compte>) compteRepository.findAll());
		mv.setViewName("listeComptes");
		return mv;
	} 
	
	@GetMapping(value="/addCompte")
	public ModelAndView  showAddCompteForm () {
		ModelAndView mv= new ModelAndView();
		   Compte compte = new Compte();
	      mv.setViewName("form");
	      mv.addObject("compte",compte);
	       return mv;
	}
	
	  @RequestMapping(value = { "/addCompte" }, method = RequestMethod.POST)
	    public ModelAndView saveCompte(ModelAndView mv, //
	            @Valid @ModelAttribute("compte") Compte compte) {
	 
	        String email = compte.getEmail();
	        String motDePasse = compte.getMotDePasse();
	 
	        if (email != null && motDePasse.length() > 0 //
	                && email != null && motDePasse.length() > 0) {
	           Compte newCompte = new Compte(email,motDePasse);
	           compteRepository.save(newCompte);
	           mv.setViewName("redirect:/comptes/add");
	            
	        }
	 
	      
	        return mv;
}
}
