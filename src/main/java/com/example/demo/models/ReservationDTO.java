package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.Date;

public class ReservationDTO {

	private Long id;
	private Date dateReservation;
	private String participant;
    private LocalDateTime dateHeureDebut;
    private LocalDateTime dateHeureFin;
	private String atelier;

	public ReservationDTO() {
	}

	public ReservationDTO(Long id, String participant, String atelier, 
			LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, Date dateReservation) {
		this.id = id;
		this.participant = participant;
		this.dateHeureDebut = dateHeureDebut;
		this.dateHeureFin = dateHeureDebut;
		this.atelier = atelier;
		this.dateReservation = dateReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
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

	public String getAtelier() {
		return atelier;
	}

	public void setAtelier(String atelier) {
		this.atelier = atelier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
