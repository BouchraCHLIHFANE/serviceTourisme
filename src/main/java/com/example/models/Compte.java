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
	Long utiliateur;

	// @NonNull
	@Column(name = "motDePasse")
	String motDePasse;

	/*
	 * @JoinColumn(name = "personne_id") private Personne personne;
	 */
	/**
	 * Many To One + eviter les boucles infinies
	 * @ManyToOne(fetch = FetchType.EAGER)
		@JsonManagedReference
		private Personne personne;
	
	 */
	 	@OneToOne( fetch = FetchType.EAGER)
	    //@JoinColumn(name = "personne_id", nullable = false)
	    private Personne personne;
	
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Compte() {
		super();
	}

	public Compte(Long utiliateur, String motDePasse, Personne personne) {
		super();
		this.utiliateur = utiliateur;
		this.motDePasse = motDePasse;
		this.personne = personne;
	}

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