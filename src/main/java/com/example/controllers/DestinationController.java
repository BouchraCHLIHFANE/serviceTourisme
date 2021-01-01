package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Destination;

@RestController
@RequestMapping(value = "destination")
public class DestinationController {
	
	@GetMapping(value = "/addDestination")
	public ModelAndView showAddCompteForm() {
		ModelAndView mv = new ModelAndView();
		Destination d= new Destination();
		mv.setViewName("index");
		mv.addObject("destination",d);
		return mv;
	}
}
