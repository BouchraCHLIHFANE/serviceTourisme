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

	public Motel(Long id, String classificaation) {
		super(id, classificaation);
	}

}
