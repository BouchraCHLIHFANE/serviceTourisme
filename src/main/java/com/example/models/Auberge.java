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

	public Auberge( String classificaation,String tarifs , String details,Destination d,String nom,String type ) {
		super( classificaation,tarifs,details,d,nom,type );
	}

}
