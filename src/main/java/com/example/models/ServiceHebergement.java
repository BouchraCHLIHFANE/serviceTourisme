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
	
	@Column(name="classification")
	String classificaation;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   // @JoinColumn(name = "TICKET_ID")  // you can rename the join column 
    private Destination destination;
	
	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public ServiceHebergement(Long id, String classificaation) {
		super();
		this.id = id;
		this.classificaation = classificaation;
	}

	public ServiceHebergement() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassificaation() {
		return classificaation;
	}

	public void setClassificaation(String classificaation) {
		this.classificaation = classificaation;
	}
	
	
}
