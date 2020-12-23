package com.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="plage")
@PrimaryKeyJoinColumn(name = "id")
public class Plage extends Destination {

	public Plage(Long id, String ville, String emplacement, String nom, String details, List<Personne> personnes) {
		super(id, ville, emplacement, nom, details, personnes);
	}
	public Plage() {
		
	}

}
