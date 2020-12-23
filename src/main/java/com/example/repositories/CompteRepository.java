package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Compte;

public interface CompteRepository extends CrudRepository<Compte,String> {
}
