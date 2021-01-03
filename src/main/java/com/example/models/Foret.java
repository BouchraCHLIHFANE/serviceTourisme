package com.example.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "foret")
@PrimaryKeyJoinColumn(name = "id")
public class Foret extends Destination{
	public Foret( String ville, String emplacement, String nom, String details,String type) {
		super(ville, emplacement, nom, details,type);
	}

	public Foret() {

	}
}
