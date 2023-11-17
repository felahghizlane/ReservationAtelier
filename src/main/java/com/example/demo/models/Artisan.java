package com.example.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Artisan")
public class Artisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String email;

    private String téléphone;

    
	public Artisan() {

	}

	public Artisan(Long id, String nom, String email, String téléphone) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.téléphone = téléphone;
	}

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

	public String getTéléphone() {
		return téléphone;
	}

	public void setTéléphone(String téléphone) {
		this.téléphone = téléphone;
	}

	@Override
	public String toString() {
		return "Artisan [id=" + id + ", nom=" + nom + ", email=" + email + ", téléphone=" + téléphone + "]";
	}


}
