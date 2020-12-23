package com.example.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "maritime")
@PrimaryKeyJoinColumn(name = "id")
public class Maritime extends MoyenDeTransport {

	public Maritime(Long id, String nom, String capacite, Double budget) {
		super(id, nom, capacite, budget);
	}
	
	public Maritime() {}
}
