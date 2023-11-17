package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Atelier;
import com.example.demo.models.Creneau;
import com.example.demo.models.Participant;
import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationDTO;
import com.example.demo.repository.CreneauRepository;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationService{

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private CreneauService creneauService;

    @Autowired
    private AtelierService atelierService;

    @Autowired
    private ReservationRepository reservationRepository;
    
    public String createReservation(Long participantId, Long creneauId, Long atelierId) {
    	
        // Récupérer le créneau et le participant sélectionnés
        Creneau creneau = creneauService.findCreneauById(creneauId);
        Participant participant = participantService.findParticipantById(participantId);
        Atelier atelier = atelierService.findAtelierById(atelierId);
        
        if (creneau == null || participant == null || atelier == null) {
        	return "erreur";
        }

        // Créer et sauvegarder la nouvelle réservation
        Reservation reservation = new Reservation(participant, creneau, atelier, new Date());
        reservationRepository.save(reservation);
        return "succes";
    }
    
    public void supprimerReservation (Long id) {
    	reservationRepository.deleteById(id);
    }
    
    public List<ReservationDTO> findReservations() {
    	List<Reservation> listResrvEntites = reservationRepository.findAll();
    	List<ReservationDTO> listResult = new ArrayList<ReservationDTO>();
    	if (listResrvEntites != null && !listResrvEntites.isEmpty()) {
    		for (Reservation reservation : listResrvEntites) {
    			ReservationDTO reservationDTO= new ReservationDTO(reservation.getId(), 
    					reservation.getParticipant().getNom(), reservation.getAtelier().getNom(), 
    					reservation.getCreneau().getDateHeureDebut(), 
    					reservation.getCreneau().getDateHeureFin(), reservation.getDateReservation());
    			listResult.add(reservationDTO);
    		}
    	}
    	return listResult;
    }
    
    public Reservation findById(Long id) {
    	return reservationRepository.findById(id).get();
    }
    
    public List<Reservation> findByCreneauId(Long creneauId) {
    	return reservationRepository.findByCreneauId(creneauId);
    }
    
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
