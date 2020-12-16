package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")

public class Client extends Personne {
	@Column(name = "pays_origine", nullable=false)
	String paysOrigine;

	@Column(name = "ville_origine")
	String villeOrigine;

	public Client(Long id, String nom, String prenom, String email, String nationalite, String adresse,
			String paysOrigine, String villeOrigine) {
		super(id, nom, prenom, email, nationalite, adresse);
		this.paysOrigine = paysOrigine;
		this.villeOrigine = villeOrigine;

	}
	
	public Client() {
		super();
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
