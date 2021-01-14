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

import com.example.models.Auberge;
import com.example.models.Destination;
import com.example.models.Foret;
import com.example.models.Hotel;
import com.example.models.Montagne;
import com.example.models.Motel;
import com.example.models.Plage;
import com.example.models.ServiceHebergement;
import com.example.repositories.AubergeRepository;
import com.example.repositories.DestinationRepository;
import com.example.repositories.HotelRepository;
import com.example.repositories.MotelRepository;
import com.example.repositories.ServiceHeberegementRepository;

@RestController
public class ServiceHebergementController {
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	AubergeRepository aubergeRepository;
	@Autowired
	DestinationRepository destinationRepository ;
	@Autowired
	MotelRepository motelRepository;
	StringBuffer alertMsg=new StringBuffer();
	@Autowired
	ServiceHeberegementRepository serviceHeberegementRepository;
	
	
	@GetMapping(value="/AddserviceHebergement")
	public ModelAndView addHebergement() {
		ModelAndView mv=new ModelAndView();
		//mv.addObject("alertMsg","false");
		List<Destination> destinations = (List<Destination>) destinationRepository.findAll();
		ServiceHebergement serviceHebergement = new ServiceHebergement();
		mv.addObject("serviceHebergement", serviceHebergement);
		mv.addObject("destinations", destinations);
		mv.addObject("alertMsg", alertMsg);
		mv.setViewName("add-Hebergement");
		return mv;
	}
	@RequestMapping(value = { "/addserviceHebergement" }, method = RequestMethod.POST)
	public ModelAndView saveServiceHebergement(ModelAndView mv, //
			@Valid @ModelAttribute("serviceHebergement") ServiceHebergement s) {
		alertMsg.append("oui");
		String nom  = s.getNom();
		String classi= s.getClassification();
		String details = s.getDetails();
		String type= s.getType();
		String tarifs= s.getTarifs();
		Destination  d= s.getDestination();
		Destination dd= destinationRepository.findById(d.getId()).orElseThrow(() -> new RuntimeException("Destination Introuvable"));
		System.out.println(type);
		 if(type==null){
			mv.addObject("status","error");
			mv.addObject("message","service introuvable, Réessayez !!");
			System.out.println("pas enreg");
		}
		 else if("hotel".equals(type)) {
			Hotel hotel= new Hotel(classi,tarifs,details,dd,nom,type );
			hotelRepository.save(hotel);
			mv.addObject("status","success");
			mv.addObject("message","hotel enregistré avec succes !!");
		}else if("motel".equals(type)) {
			Motel motel= new Motel(classi,tarifs,details,dd,nom,type );
			motelRepository.save(motel);
			mv.addObject("status","success");
			mv.addObject("message","motel enregistré avec succes !!");
		}else if("auberge".equals(type)) {
			Auberge auberge= new Auberge(classi,tarifs,details,dd,nom,type );
			aubergeRepository.save(auberge);
			mv.addObject("status","success");
			mv.addObject("message","auberge enregistré avec succes !!");
			System.out.println("enreg");
		}
		 mv.addObject("alertMsg",alertMsg);
		mv.setViewName("redirect:/gestionHebergement");
		return mv;
	}
	@GetMapping(value="/gestionHebergement")
	public ModelAndView gestionHebergement() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("hotels",(List<Hotel>) hotelRepository.findAll());
		mv.addObject("motels",(List<Motel>) motelRepository.findAll());
		mv.addObject("auberges",(List<Auberge>) aubergeRepository.findAll());
		mv.setViewName("gestionHebergement");
		return mv;
	} 
			
	@GetMapping(value="/delete/{heberegementId}")
	public ModelAndView deleteServiceHebergement(@PathVariable Long heberegementId) {
		 ModelAndView mv= new ModelAndView();
		 ServiceHebergement S=serviceHeberegementRepository.findById(heberegementId).orElseThrow(() -> new RuntimeException("Destination Introuvable"));
		 if(S.getType().equals("hotel")) {
			 hotelRepository.deleteById(heberegementId);
		 }else if(S.getType().equals("motel")) {
			motelRepository.deleteById(heberegementId);
		 }else if(S.getType().equals("auberge")) {
			 aubergeRepository.deleteById(heberegementId);
		 }
		 
		 mv.setViewName("redirect:/gestionHebergement");
		 return mv;
	}
	
	@GetMapping(value = "/edit/{hebergementId}")
	public ModelAndView edit(@PathVariable Long hebergementId, Model model, RedirectAttributes redirectAttr) {
		ModelAndView mv = new ModelAndView();
		try {
		//	if (hebergementId > 0) {
				ServiceHebergement serviceHebergement =serviceHeberegementRepository.findById(hebergementId).orElseThrow(() -> new RuntimeException("Destination Introuvable"));
				if (serviceHebergement != null) {
					model.addAttribute("serviceHebergement", serviceHebergement);
					mv.setViewName("edit-hebergement");
				} else {
					mv.addObject("message", "No destination was matched");
					System.out.println("introuvable");
				}
		//}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	@PostMapping(value = "/update/{hebergementId}")
	public ModelAndView update(@Valid @ModelAttribute ServiceHebergement serviceHebergement,@PathVariable Long hebergementId) {
		ModelAndView mv= new ModelAndView();
		//System.out.println(destinationId);
		//System.out.println(compte.getEmail());
		ServiceHebergement serviceHebergement1 =serviceHeberegementRepository.findById(hebergementId).orElseThrow(() -> new RuntimeException("Destination Introuvable"));		
		String type= serviceHebergement.getType();
		System.out.println(type);
		serviceHebergement1.setNom(serviceHebergement.getNom());
		serviceHebergement1.setClassification(serviceHebergement.getClassification());
		serviceHebergement1.setDetails(serviceHebergement.getDetails());
		serviceHebergement1.setTarifs(serviceHebergement.getTarifs());
		serviceHebergement1.setType(serviceHebergement.getType());
		// il reste la modif de la destionation à proximité /a completer 
		
	
			if(type.equals("hotel")){
					serviceHebergement1=hotelRepository.save((Hotel)serviceHebergement1);
					}else if(type.equals("motel")) {
					serviceHebergement1=motelRepository.save((Motel) serviceHebergement1);
					}else if(type.equals("auberge")) {
					serviceHebergement1=aubergeRepository.save((Auberge) serviceHebergement1);
					}
			
		mv.setViewName("redirect:/gestionHebergement");
		return mv;
	}
	
}
