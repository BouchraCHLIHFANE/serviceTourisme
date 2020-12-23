package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "destination")
//@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Inheritance(strategy=InheritanceType.JOINED)
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	@Column(name = "ville")
	String ville;

	@Column(name = "emplacement")
	String emplacement;

	@Column(name = "nom")
	String nom;

	@Column(name = "details")
	String details;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,

	})
	@JoinTable
	private List<Personne> personnes = new ArrayList<>();

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public Destination() {
	}

	public Destination(Long id, String ville, String emplacement, String nom, String details,
			List<Personne> personnes) {
		super();
		this.id = id;
		this.ville = ville;
		this.emplacement = emplacement;
		this.nom = nom;
		this.details = details;
		this.personnes = personnes;
	}

	/*
	 * @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	 * // @JoinColumn(name = "TICKET_ID") // you can rename the join column private
	 * ServiceHebergement serviceHebergement;
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
