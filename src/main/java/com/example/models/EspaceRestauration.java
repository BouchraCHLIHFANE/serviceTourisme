package com.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "espaceRestauration")
@PrimaryKeyJoinColumn(name = "id")
public class EspaceRestauration extends Destination {

	public EspaceRestauration(Long id, String ville, String emplacement, String nom, String details,
			List<Personne> personnes) {
		super(id, ville, emplacement, nom, details, personnes);
	}

	public EspaceRestauration() {

	}

}
