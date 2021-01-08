package com.example.models;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity(name = "compte")
public class Compte {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email")
	String email;
	*/
	/*
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "email")
	String email;
*/
	// @NonNull
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	Long id;
	@Column(name = "email")
	String email;
	
	@Column(name = "motDePasse")
	String motDePasse;
	@OneToOne(fetch = FetchType.EAGER)
	// si on veut nomer la colonne
	//@JoinColumn(name = "compte_id")
	private Personne personne;

	/*
	 * @JoinColumn(name = "personne_id") private Personne personne;
	 */
	/**
	 * Many To One + eviter les boucles infinies
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * @JsonManagedReference private Personne personne;
	 * 
	 */
	

	
	//@Column(name = "photo", columnDefinition="BLOB")
	@Column(name = "photo" ,nullable = true, length = 64)
    private String profilePicture;
	
	// Pour autoriser l'accès au répertoire user-photos dans le système de fichiers
	@Transient
    public String getPhotosImagePath() {
        if (profilePicture == null || id == null) return null;
         
        return "/imagesComptes/" + id + "/" + profilePicture;
    }
	
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String fileName) {
		this.profilePicture = fileName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Compte() {
	}

	public Compte(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;

	}
	public Compte(String email, String motDePasse,String photo) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
		this.profilePicture=photo;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Compte [email=" + email + ", motDePasse=" + motDePasse + "]";
	}

}