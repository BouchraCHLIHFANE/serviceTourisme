package com.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="montagne")
@PrimaryKeyJoinColumn(name = "id")
public class Montagne extends Destination{


	public Montagne(String ville, String emplacement, String nom, String details,String type) {
		super(ville, emplacement, nom, details, type);
	}
	public Montagne() {
		
	}
}
