package com.example.models;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import sun.security.krb5.internal.Ticket;

@Entity
@Table(name="servicehebergement")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Inheritance(strategy=InheritanceType.JOINED)
public class ServiceHebergement {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	Long id;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="type")
	String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	@Column(name="classification")
	String classification;
	
	@Column(name="tarifs")
	String tarifs;
	
	@Column(name="details")
	String details;
	



	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   // @JoinColumn(name = "TICKET_ID")  // you can rename the join column 
    private Destination destination;
	
	
	public String getTarifs() {
		return tarifs;
	}

	public void setTarifs(String tarifs) {
		this.tarifs = tarifs;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	

	public ServiceHebergement(String classificaation, String tarifs, String details, Destination destination,String nom,String type) {
		super();
		this.classification = classificaation;
		this.tarifs = tarifs;
		this.details = details;
		this.destination = destination;
		this.nom=nom;
		this.type=type;
	}

	public ServiceHebergement() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classificaation) {
		this.classification = classificaation;
	}
	
	@Override
	public String toString() {
		return "ServiceHebergement [id=" + id + ", classification=" + classification + ", tarifs=" + tarifs
				+ ", details=" + details + ", destination=" + destination + "]";
	}
	
}
