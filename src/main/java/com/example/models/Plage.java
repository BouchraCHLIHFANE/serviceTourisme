package com.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="plage")
@PrimaryKeyJoinColumn(name = "id")
public class Plage extends Destination {

	public Plage(String ville, String emplacement, String nom, String details,String type) {
		super(ville, emplacement, nom, details, type);
	}
	public Plage() {
		
	}

}
