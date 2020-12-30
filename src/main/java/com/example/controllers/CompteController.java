package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Compte;
import com.example.repositories.CompteRepository;
import com.example.services.CompteService;
//@RestController
@Controller
@RequestMapping(value = "compte")
public class CompteController {
	
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	CompteService compteService;
   
	@GetMapping(value = "/")
	public List<Compte> findComptesPatient() {
		return (List<Compte>) compteRepository.findAll();

	}
	// ca n'a pas marché avec Medel ,, ca retourne une chaines de char "listeComptes" ??
	/*
	public String list(Model model) {
		model.addAttribute("pageTitle", "Comptes | View");
		model.addAttribute("studentList", (List<Compte>) compteRepository.findAll());
		return "listeComptes";
	}
	*/

	@GetMapping(value = "/view")
	public ModelAndView list(ModelAndView mv) {
		
		mv.addObject("pageTitle", "Comptes | View");
		ArrayList <Compte> comptes =(ArrayList<Compte>) compteRepository.findAll();
		mv.setViewName("listeComptes");	
		mv.addObject("nom", "wick");
		mv.addObject("comptesListes", comptes);
		
		return mv;
		
	}
	/*
	@PostMapping(value="/addCompte")
    public ModelAndView saveCompte( @ModelAttribute("compte") Compte compte,ModelAndView mv ) {
		StringBuffer message=new StringBuffer();
        String utilisateur = compte.getUtiliateur();
        String mdp = compte.getMotDePasse();
 
        if (utilisateur != null && utilisateur.length() > 0 && mdp != null && mdp.length() > 0)  
        		{
            Compte newCompte = new Compte(utilisateur, mdp);
            newCompte=compteRepository.save(newCompte);
            message.append("compte enregistré avec succes");
        		}
        else message.append("Ressayez encore une fois");
        mv.setViewName("listeComptes");
        
		mv.setViewName("listeComptes");
        return mv;
		}
	*/
	@GetMapping(value="/register")
	public ModelAndView showForm(ModelAndView mv) {
		mv.addObject("newCompte",new Compte());
		mv.setViewName("redirect:/form.html");
	
		return mv;
	}
	@PostMapping(value="/register")
	public ModelAndView  submittForm(@Valid @ModelAttribute ("compte") Compte compte,ModelAndView mv ) {
		Compte comptee = compteRepository.save(compte);
		mv.addObject("compte",comptee);
		mv.setViewName("listeComptes");
		return mv;
		
	}
}