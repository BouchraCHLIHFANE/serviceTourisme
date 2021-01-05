package com.example.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
@PrimaryKeyJoinColumn(name = "id")
public class Hotel extends ServiceHebergement {

	public Hotel() {
	}

	public Hotel(String classificaation,String tarifs , String details,Destination d,String nom,String type) {
		super( classificaation,tarifs,details,d,nom,type );
	}

}
