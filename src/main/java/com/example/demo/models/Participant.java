package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String telephone;
    
    //Constructeurs
	public Participant() {
	}
	
	public Participant(Long id, String nom, String email, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
	}
	 // Getters et Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
//Affichage TOSTRING
	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", email=" + email + ", telephone=" + telephone + "]";
	}
 
    
    
}
