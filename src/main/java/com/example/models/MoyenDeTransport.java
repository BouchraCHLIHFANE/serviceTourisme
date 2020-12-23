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

@Table
@Entity(name = "moyenDeTransport")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Inheritance(strategy=InheritanceType.JOINED)
public class MoyenDeTransport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name = "nom")
	String nom;

	@Column(name = "capacite")
	String capacite;

	@Column(name = "budget")
	Double budget;

	// manyToMany avec client
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,

	})
	@JoinTable
	private List<Client> clients = new ArrayList<>();

	public MoyenDeTransport(Long id, String nom, String capacite, Double budget) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.budget = budget;
	}

	public MoyenDeTransport() {
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

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

}
