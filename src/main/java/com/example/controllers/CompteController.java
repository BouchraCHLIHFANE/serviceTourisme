package com.example.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
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

@RestController
@RequestMapping(value = "comptes")
public class CompteController {

	@Autowired
	private CompteService compteService;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * direction vers la page d'accueil
	 */
	@GetMapping(value = "/")
	public ModelAndView Authentification() {
		ModelAndView mv = new ModelAndView();
		Compte compte = new Compte();
		mv.addObject("compte", compte);
		mv.setViewName("accueil");
		return mv;
	}

	/*
	 * methode pour assurer l'authentification de l'utilisateur prend en parametres
	 * un objet de type Compte pour vérifier l'email et mdp de l'utilisateur
	 */
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
	 * methode pour diriger l'utilisateur vers la page ou il peut ajouter un nouveau
	 * compte
	 */
	@GetMapping(value = "/addCompte")
	public ModelAndView showAddCompteForm() {
		ModelAndView mv = new ModelAndView();
		Compte compte = new Compte();
		mv.setViewName("form");
		mv.addObject("compte", compte);
		return mv;
	}

	/*
	 * methode pour ajouter un nouveau compte prend en param un objet de type compte
	 * et une image (multipart file)
	 */
	@RequestMapping(value = { "/addCompte" }, method = RequestMethod.POST)
	public ModelAndView saveeCompte(ModelAndView mv, //
			@Valid @ModelAttribute("compte") Compte compte, @RequestParam("picture") MultipartFile multipartFile)
			throws IOException {

		String fileName = org.springframework.util.StringUtils.cleanPath(multipartFile.getOriginalFilename());
		compte.setProfilePicture(fileName);
		Compte newCompte = compteRepository.save(compte);
		String uploadDir = "imagesComptes/" + newCompte.getId();
		// voir la classe FileUploadUtil
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		/*
		 * String email = compte.getEmail(); String motDePasse = compte.getMotDePasse();
		 * 
		 * 
		 * if (email != null && motDePasse.length() > 0 // && email != null &&
		 * motDePasse.length() > 0) { Compte newCompte = new Compte(email, motDePasse);
		 * newCompte.setProfilePicture(fileName); compteRepository.save(newCompte);
		 * mv.setViewName("redirect:/comptes/add"); }
		 */
		mv.setViewName("/redirect:/listeComptes");
		return mv;
	}

	/*
	 * methode pour lister les comptes existants
	 */
	@GetMapping(value = "/listeComptes")
	public ModelAndView getListeComptes() {
		ModelAndView mv = new ModelAndView();
		List<Compte> comptes = (List<Compte>) compteRepository.findAll();
		mv.addObject("comptesListes", comptes);
		mv.setViewName("listeComptes");
		return mv;
	}

	/*
	 * methode pour quitter la session retourne un ModelAndView
	 */
	@GetMapping(value = "/logout")
	public ModelAndView logOut() {
		ModelAndView mv = new ModelAndView();
		// on doit impérativement envoyer un objet avec sinon ca marche pas
		mv.addObject("compte", new Compte());
		mv.setViewName("accueil");
		return mv;
	}
}
