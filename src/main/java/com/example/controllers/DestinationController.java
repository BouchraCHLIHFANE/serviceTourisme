package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Destination;
import com.example.models.Foret;
import com.example.models.Montagne;
import com.example.models.Plage;
import com.example.repositories.DestinationRepository;
import com.example.repositories.ForetRepository;
import com.example.repositories.MontagneRepository;
import com.example.repositories.PlageRepository;

@RestController
@RequestMapping(value = "destination")
public class DestinationController {
	
	@Autowired
	PlageRepository plageRepository;
	@Autowired
	DestinationRepository destinationRepository;
	@Autowired
	MontagneRepository montagneRepository;
	@Autowired
	ForetRepository foretRepository;
	
	@GetMapping(value = "/addDestination")
	public ModelAndView showAddCompteForm() {
		ModelAndView mv = new ModelAndView();
		Destination d= new Destination();
		mv.setViewName("add-destination");
		mv.addObject("destination",d);
		return mv;
	}
	
	@RequestMapping(value = { "/addDestination" }, method = RequestMethod.POST)
	public ModelAndView saveCompte(ModelAndView mv, //
			@Valid @ModelAttribute("destination") Destination destination) {

		String nom = destination.getNom();
		String ville = destination.getVille();
		String details =destination.getDetails();
		String type = destination.getType();
		String emplacement=destination.getEmplacement();
		//System.out.println(type);
		
		
	//	if (nom != null && nom.length() > 0 //
		//		&& ville != null && ville.length() > 0 && details != null && details.length() > 0 && type != null && type.length() > 0) {
			if(type.equals("plage")) {
				Plage plage = new Plage(ville, emplacement, nom, details, type);
				//Destination d= new Destination(ville, emplacement, nom, details, type);
				plageRepository.save(plage);
			}else if(type.equals("montagne")) {
				Montagne montagne = new Montagne(ville, emplacement, nom, details, type);
				montagneRepository.save(montagne);
			}else if(type.equals("foret")) {
				Foret foret = new Foret(ville, emplacement, nom, details, type);
				foretRepository.save(foret);
			}else {
				mv.addObject("msg","Vous devez choisir impérativement votre destination");
			}
			
		mv.setViewName("redirect:/destination/addDestination");
		return mv;
	}
	
}
