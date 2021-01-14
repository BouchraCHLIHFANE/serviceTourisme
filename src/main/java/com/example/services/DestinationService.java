package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Destination;
import com.example.repositories.DestinationRepository;

@Service
public class DestinationService {
	
	@Autowired
	DestinationRepository destinationRepository;
	
	public String findPhotoById(Long id) {
		List<Destination> destinations = (List<Destination>) destinationRepository.findAll();
		for (Destination D:destinations) {
			if(D.getId()==id) {
				return D.getProfilePicture();
			}
		}
		return null;
		
	}
}
