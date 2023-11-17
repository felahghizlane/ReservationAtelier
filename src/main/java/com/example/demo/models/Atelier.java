package com.example.demo.models;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Atelier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "artisan_id")
    private Artisan artisan;
    
    ///////////////////Constructeurs 
	public Atelier() {
	}
		
	public Atelier(Long id, String nom, String description, Artisan artisan) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.artisan = artisan;
		
	}
	//////////////////Getters et Setters
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Artisan getArtisan() {
		return artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}

}
