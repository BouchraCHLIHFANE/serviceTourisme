package com.example.models;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "destination")
//@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Inheritance(strategy=InheritanceType.JOINED)
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	@Column(name = "ville")
	String ville;

	@Column(name = "emplacement")
	String emplacement;

	@Column(name = "nom")
	String nom;

	@Column(name = "details")
	String details;
	
	@Column(name = "type")
	String type;
	/*
	@Column(name = "photo" ,nullable = true, length = 64,columnDefinition = "LONGBLOB")
    private String profilePicture;
	*/
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private String ProfilePicture;
   

	// Pour autoriser l'accès au répertoire user-photos dans le système de fichiers
	
	/*
	@Transient
    public String getPhotosImagePath() {
        if (profilePicture == null || id == null) return null;
         
        return "/imagesComptes/" + id + "/" + profilePicture;
    }

*/
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,

	})
	@JoinTable
	private List<Personne> personnes = new ArrayList<>();

	@OneToMany(targetEntity=ServiceHebergement.class, mappedBy="destination",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<ServiceHebergement> servicesHebergement = new ArrayList<>();
	/*

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	*/
	public List<Personne> getPersonnes() {
		return personnes;
	}


	public String getProfilePicture() {
		return ProfilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		ProfilePicture = profilePicture;
	}


	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public Destination() {
	}

	public Destination( String ville, String emplacement, String nom, String details,
		String type) {
		super();
		this.id = id;
		this.ville = ville;
		this.emplacement = emplacement;
		this.nom = nom;
		this.details = details;
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ServiceHebergement> getServicesHebergement() {
		return servicesHebergement;
	}

	public void setServicesHebergement(List<ServiceHebergement> servicesHebergement) {
		this.servicesHebergement = servicesHebergement;
	}

	/*
	 * @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	 * // @JoinColumn(name = "TICKET_ID") // you can rename the join column private
	 * ServiceHebergement serviceHebergement;
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
