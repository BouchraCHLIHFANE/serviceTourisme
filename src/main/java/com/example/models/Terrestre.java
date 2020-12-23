package com.example.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "terrestre")
@PrimaryKeyJoinColumn(name = "id")
public class Terrestre extends MoyenDeTransport {

	public Terrestre(Long id, String nom, String capacite, Double budget) {
		super(id, nom, capacite, budget);
	}

	public Terrestre() {
	}
}
