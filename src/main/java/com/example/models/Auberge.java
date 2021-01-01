package com.example.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "auberge")
@PrimaryKeyJoinColumn(name = "id")
public class Auberge extends ServiceHebergement {

	
	public Auberge() {

	}

	public Auberge(Long id, String classificaation) {
		super(id, classificaation);
	}

}
