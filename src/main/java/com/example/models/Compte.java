package com.example.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.*;

@Table
@Entity(name = "compte")
public class Compte  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long utiliateur;

	// @NonNull
	@Column(name = "motDePasse")
	String motDePasse;

	public Long getUtiliateur() {
		return utiliateur;
	}

	public void setUtiliateur(Long utiliateur) {
		this.utiliateur = utiliateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Compte(Long utiliateur, String motDePasse) {
		super();
		this.utiliateur = utiliateur;
		this.motDePasse = motDePasse;
	}

	

}