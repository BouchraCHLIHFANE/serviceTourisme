package com.example.models;

import javax.persistence.*;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	// @NonNull
	@Column(name = "nom")
	String nom;

	@Column(name = "prenom")
	String prenom;

	@Column(name = "email")
	String email;

	@Column(name = "nationalite")
	String nationalite;

	@Column(name = "adresse")
	String adresse;

	public Personne(Long id, String nom, String prenom, String email, String nationalite, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.nationalite = nationalite;
		this.adresse = adresse;
	}

	public Personne() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
