package com.example.models;

import javax.persistence.Column;

public class Client extends Personne{
	@Column(name = "pays_origine")
	String paysOrigine;
	
	@Column(name = "ville_origine")
	String villeOrigine;
	

	public Client(Long id, String nom, String prenom, String email, String nationalite, String adresse,String paysOrigine, String villeOrigine ) {
		super(id, nom, prenom, email, nationalite, adresse);
		this.paysOrigine=paysOrigine;
		this.villeOrigine=villeOrigine;

		}


	public String getPaysOrigine() {
		return paysOrigine;
	}


	public void setPaysOrigine(String paysOrigine) {
		this.paysOrigine = paysOrigine;
	}


	public String getVilleOrigine() {
		return villeOrigine;
	}


	public void setVilleOrigine(String villeOrigine) {
		this.villeOrigine = villeOrigine;
	}
	
	

}
