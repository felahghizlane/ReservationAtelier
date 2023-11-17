package com.example.demo.models;

import java.time.LocalDateTime;
import java.time.Duration;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Creneau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;

    @ManyToOne
    @JoinColumn(name = "atelier_id", referencedColumnName = "id")
    private Atelier atelier;

    // Constructeurs, Getters et Setters

    public Creneau() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public LocalDateTime getDateHeureFin() {
        return dateHeureFin;
    }

    public void setDateHeureFin(LocalDateTime dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public Integer getDuree() {
        if (dateHeureDebut != null && dateHeureFin != null) {
            return (int) Duration.between(dateHeureDebut, dateHeureFin).toMinutes();
        } else {
            return null;
        }
    }
}
