package com.example.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "motel")
@PrimaryKeyJoinColumn(name = "id")

public class Motel extends ServiceHebergement {
	public Motel() {

	}

	public Motel(String classificaation,String tarifs , String details,Destination d,String nom,String type) {
		super(classificaation,tarifs,details,d ,nom,type);
	}


}
