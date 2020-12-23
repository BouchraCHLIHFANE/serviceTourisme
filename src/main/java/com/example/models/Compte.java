package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity(name = "compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email")
	String email;
	

	// @NonNull
	@Column(name = "motDePasse")
	String motDePasse;

	/*
	 * @JoinColumn(name = "personne_id") private Personne personne;
	 */
	/**
	 * Many To One + eviter les boucles infinies
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * @JsonManagedReference private Personne personne;
	 * 
	 */

	public Compte() {
		super();
	}

	public Compte(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;

	}

	public String getUtiliateur() {
		return email;
	}

	public void setUtiliateur(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}