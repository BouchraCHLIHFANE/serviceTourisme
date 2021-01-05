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

import com.example.models.Auberge;
import com.example.models.Destination;
import com.example.models.Hotel;
import com.example.models.Motel;
import com.example.models.ServiceHebergement;
import com.example.repositories.AubergeRepository;
import com.example.repositories.DestinationRepository;
import com.example.repositories.HotelRepository;
import com.example.repositories.MotelRepository;

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
		mv.setViewName("redirect:/AddserviceHebergement");
		return mv;
	}
	
}
