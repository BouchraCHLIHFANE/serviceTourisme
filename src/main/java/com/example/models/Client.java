package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")

public class Client extends Personne {

	@Column(name = "pays_origine", nullable = false)
	String paysOrigine;

	@Column(name = "ville_origine")
	String villeOrigine;

	@ManyToMany(mappedBy = "clients")
	private List<MoyenDeTransport> moyensDeTransport = new ArrayList<>();

	public List<MoyenDeTransport> getMoyenDeTransport() {
		return moyensDeTransport;
	}

	public void setMoyenDeTransport(List<MoyenDeTransport> moyensDeTransport) {
		this.moyensDeTransport = moyensDeTransport;
	}

	public Client(Long id, String nom, String prenom, String email, String nationalite, String adresse,
			List<Destination> destinations, Compte compte, String paysOrigine, String villeOrigine,
			List<MoyenDeTransport> moyenDeTransport) {
		super(id, nom, prenom, email, nationalite, adresse, destinations, compte);
		this.paysOrigine = paysOrigine;
		this.villeOrigine = villeOrigine;
		this.moyensDeTransport = moyenDeTransport;
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
