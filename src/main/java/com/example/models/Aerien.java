package com.example.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "aerien")
@PrimaryKeyJoinColumn(name = "id")
public class Aerien extends MoyenDeTransport {

	public Aerien(Long id, String nom, String capacite, Double budget) {
		super(id, nom, capacite, budget);
	}
	public Aerien() {
		
	}

}
