package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public Compte() {
	}

	public Compte(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;

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