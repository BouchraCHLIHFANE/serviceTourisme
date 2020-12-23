package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	Long id;

	// @NonNull
	@Column(name = "nom", length = 40)
	String nom;

	@Column(name = "prenom")
	String prenom;

	

	@Column(name = "nationalite")
	String nationalite;

	@Column(name = "adresse")
	String adresse;
	/*
	 * @OneToMany(mappedBy="personne") private List <Compte> comptes ;
	 */
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable private List<Destination> destinations = new ArrayList<>();
	 */

	@ManyToMany(mappedBy = "personnes")
	private List<Destination> destinations = new ArrayList<>();

	
	@OneToOne(fetch = FetchType.EAGER)
	// si on veut nomer la colonne
	//@JoinColumn(name = "compte_id")
	private Compte compte;

	public Personne(Long id, String nom, String prenom, String nationalite, String adresse,
			List<Destination> destinations, Compte compte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.destinations = destinations;
		this.compte = compte;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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
