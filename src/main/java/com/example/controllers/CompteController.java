package com.example.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Compte;
import com.example.repositories.CompteRepository;
import com.example.services.CompteService;


import java.io.*;
import java.nio.file.*;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "comptes")

public class CompteController {

	@Autowired
	private CompteService compteService;
	@Autowired
	private CompteRepository compteRepository;

	@GetMapping(value = "/")
	public ModelAndView Authentification() {
		ModelAndView mv = new ModelAndView();
		Compte compte = new Compte();
		mv.addObject("compte", compte);
		mv.setViewName("accueil");
		return mv;

	}

	@RequestMapping(value = { "/authentification" }, method = RequestMethod.POST)
	public ModelAndView saveCompte(ModelAndView mv, @Valid @ModelAttribute("compte") Compte compte) {

		String email = compte.getEmail();
		String motDePasse = compte.getMotDePasse();
		List<Compte> listeComptes = (List<Compte>) compteRepository.findAll();
		for (Compte C : listeComptes) {
			if (email.equals(C.getEmail()) && motDePasse.equals(C.getMotDePasse())) {
				System.out.println("bien authentifié");
				mv.setViewName("redirect:/destination/addDestination");
				return mv;
			}
		}

		mv.setViewName("redirect:/comptes/");
		return mv;
	}

	/*
	 * 
	 * @GetMapping(value = "/add") public ModelAndView listComptes(ModelAndView mv)
	 * { mv.addObject("pageTitle", "Students | Add"); mv.addObject("comptesListes",
	 * (List<Compte>) compteRepository.findAll()); mv.setViewName("listeComptes");
	 * return mv; }
	 */
	@GetMapping(value = "/addCompte")
	public ModelAndView showAddCompteForm() {
		ModelAndView mv = new ModelAndView();
		Compte compte = new Compte();
		mv.setViewName("form");
		mv.addObject("compte", compte);
		return mv;
	}

	@RequestMapping(value = { "/addCompte" }, method = RequestMethod.POST)
	public ModelAndView saveeCompte(ModelAndView mv, //
			@Valid @ModelAttribute("compte") Compte compte, @RequestParam("picture") MultipartFile multipartFile)
			throws IOException {
		
		String fileName =org.springframework.util.StringUtils.cleanPath(multipartFile.getOriginalFilename());
		compte.setProfilePicture(fileName);
		Compte newCompte =compteRepository.save(compte);
		String uploadDir = "imagesComptes/" + newCompte.getId();
		// voir la classe FileUploadUtil
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		/*String email = compte.getEmail();
		String motDePasse = compte.getMotDePasse();
		
		
		if (email != null && motDePasse.length() > 0 //
				&& email != null && motDePasse.length() > 0) {
			Compte newCompte = new Compte(email, motDePasse);
			newCompte.setProfilePicture(fileName);
			compteRepository.save(newCompte);
			mv.setViewName("redirect:/comptes/add");
		}
		*/
		return mv;
	}
	@GetMapping(value="/listeComptes")
	public ModelAndView getListeComptes() {
		ModelAndView mv= new ModelAndView();
		List <Compte> comptes= (List <Compte>) compteRepository.findAll();
		mv.addObject("comptesListes", comptes);
		mv.setViewName("listeComptes");
		return mv;
		
	}
	/*
	 * @GetMapping(value = "/edit/{compteId}") public ModelAndView
	 * edit(@PathVariable Long compteId, Model model, RedirectAttributes
	 * redirectAttr) { ModelAndView mv = new ModelAndView(); try { if (compteId > 0)
	 * { Compte compte= compteRepository.findById(compteId).orElseThrow(() -> new
	 * RuntimeException("Compte Introuvable"));
	 * System.out.println("l'id est :"+compte.getId()); if (compte != null) {
	 * model.addAttribute("compte", compte); mv.setViewName("edit-compte"); } else {
	 * mv.addObject("message", "No student was matched"); } } } catch (Exception e)
	 * { System.out.println(e); } return mv; }
	 * 
	 * @PostMapping(value = "/update/{compteId}") public ModelAndView
	 * update(@Valid @ModelAttribute Compte compte,@PathVariable Long compteId) {
	 * ModelAndView mv= new ModelAndView(); System.out.println(compteId);
	 * System.out.println(compte.getEmail()); Compte comptee =
	 * compteRepository.findById(compteId).orElseThrow(() -> new
	 * RuntimeException("Compte Introuvable"));;
	 * 
	 * // Compte newCompte = comptee.get(); comptee.setEmail(compte.getEmail());
	 * comptee.setMotDePasse(compte.getMotDePasse()); comptee =
	 * compteRepository.save(comptee); mv.setViewName("redirect:/comptes/add");
	 * return mv; }
	 * 
	 * @GetMapping(value="/delete/{compteId}") public ModelAndView
	 * deleteCompte(@PathVariable Long compteId) { ModelAndView mv= new
	 * ModelAndView(); compteRepository.deleteById(compteId);
	 * mv.setViewName("redirect:/comptes/add"); return mv; }
	 */
}
