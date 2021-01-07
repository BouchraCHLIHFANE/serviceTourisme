package com.example.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.models.Compte;
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
	public ModelAndView showAddDestinationForm() {
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
			
		mv.setViewName("redirect:/destination/gestionDestination");
		return mv;
	}
	/*
	@GetMapping(value = "/")
	public ModelAndView gestionDestination() {
		ModelAndView mv = new ModelAndView();
		//Destination d= new Destination();
		mv.setViewName("gestionDestination");
		//mv.addObject("destination",d);
		return mv;
	}
	*/
	@GetMapping(value = "/gestionDestination")
	public ModelAndView listDestination(ModelAndView mv) {
		mv.addObject("pageTitle", "Destination ::Gestion");
		mv.addObject("ListPlages", (List<Plage>) plageRepository.findAll());
		mv.addObject("ListForets", (List<Foret>) foretRepository.findAll());
		mv.addObject("ListMontagnes", (List<Montagne>) montagneRepository.findAll());
		mv.setViewName("gestionDestination");
		return mv;
	}
	
	@GetMapping(value="/delete/{destinationId}")
	public ModelAndView deleteDestination(@PathVariable Long destinationId) {
		 ModelAndView mv= new ModelAndView();
		 Destination d=destinationRepository.findById(destinationId).orElseThrow(() -> new RuntimeException("Destination Introuvable"));
		 if(d.getType().equals("plage")) {
			 plageRepository.deleteById(destinationId);
		 }else if(d.getType().equals("montagne")) {
			 montagneRepository.deleteById(destinationId);
		 }else if(d.getType().equals("foret")) {
			 foretRepository.deleteById(destinationId);
		 }
		 
		 mv.setViewName("redirect:/destination/gestionDestination");
		 return mv;
	}
	
	@GetMapping(value = "/edit/{destinationId}")
	public ModelAndView edit(@PathVariable Long destinationId, Model model, RedirectAttributes redirectAttr) {
		ModelAndView mv = new ModelAndView();
		try {
			if (destinationId > 0) {
				Destination destination=destinationRepository.findById(destinationId).orElseThrow(() -> new RuntimeException("Destination Introuvable"));
				if (destination != null) {
					model.addAttribute("destination", destination);
					mv.setViewName("edit-destination");
				} else {
					mv.addObject("message", "No destination was matched");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	@PostMapping(value = "/update/{destinationId}")
	public ModelAndView update(@Valid @ModelAttribute Destination destination,@PathVariable Long destinationId) {
		ModelAndView mv= new ModelAndView();
		//System.out.println(destinationId);
		//System.out.println(compte.getEmail());
		Destination d  = destinationRepository.findById(destinationId).orElseThrow(() -> new RuntimeException("destination Introuvable"));;
		String type= destination.getType();
		System.out.println(type);
		d.setNom(destination.getNom());
		d.setEmplacement(destination.getEmplacement());
		d.setVille(destination.getVille());
		d.setType(destination.getType());
		d.setDetails(destination.getDetails());
			if(type.equals("plage")){
					d=plageRepository.save((Plage) d);
					}else if(d.getType().equals("montagne")) {
					d=montagneRepository.save((Montagne) d);
					}else if(d.getType().equals("foret")) {
					d=foretRepository.save((Foret) d);
					}
			
		mv.setViewName("redirect:/destination/gestionDestination");
		return mv;
	}
	
}
