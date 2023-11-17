package com.example.demo.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "date_reservation")
	private Date dateReservation;

	@ManyToOne
	@JoinColumn(name = "participant_id")
	private Participant participant;

	@ManyToOne
	@JoinColumn(name = "creneau_id")
	private Creneau creneau;

	@ManyToOne
	@JoinColumn(name = "atelier_id")
	private Atelier atelier;

	public Reservation() {
	}

	public Reservation(Participant participant, Creneau creneau, Atelier atelier, Date date) {
		this.participant = participant;
		this.creneau = creneau;
		this.atelier = atelier;
		this.dateReservation = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}

}
