package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Long> {
	
}
