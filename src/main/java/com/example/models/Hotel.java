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

	public Hotel(Long id, String classificaation) {
		super(id, classificaation);
	}

}
