package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.AtelierService;
import com.example.demo.service.CreneauService;
import com.example.demo.service.ParticipantService;
import com.example.demo.service.ReservationService;
import com.example.demo.models.Participant;
import com.example.demo.models.Reservation;
import com.example.demo.models.Creneau;

import java.util.List;

@Controller
public class ReservationController {

	private final ReservationService reservationService;
	private final CreneauService creneauService;
	private final ParticipantService participantService;
	private final AtelierService atelierService;

	@Autowired
	public ReservationController(ReservationService reservationService, CreneauService creneauService,
		      ParticipantService participantService, AtelierService atelierService) {
	    this.reservationService = reservationService;
	    this.creneauService = creneauService;
	    this.participantService = participantService;
	    this.atelierService = atelierService;
	}

    @GetMapping("/reservations")
    public String showReservationsList(Model model) {
        model.addAttribute("reservations", reservationService.findReservations());
        return "reservations"; 
    }
    
	@GetMapping("/ReservationCreneau")
	public String showReservationCreneau(Model model) {
	    model.addAttribute("ateliers", atelierService.getAllAteliers()); // Liste des ateliers
	    model.addAttribute("creneaux", creneauService.findAllCreneauxDisponibles(null)); // Liste des créneaux disponibles
	    model.addAttribute("participants", participantService.findAllParticipants());
	    return "reservationCreneau"; // Nom de Thymeleaf
	}

	@PostMapping("/reserve")
	public String processReservation(@RequestParam("creneauId") Long creneauId,
			@RequestParam("participantId") Long participantId, @RequestParam("atelierId") Long atelierId,
			Model model) {
		try {
			System.out.println(creneauId);
			System.out.println(participantId);

			String result = reservationService.createReservation(participantId, creneauId, atelierId);
			if (result.equals("erreur")) {
				System.out.println("Créneau ou participant invalide.");
				model.addAttribute("error", "Créneau ou participant invalide.");
			} else {
				model.addAttribute("error", "Reservation cree avec succes.");
				System.out.println("Reservation cree avec succes.");
			}

			// Rediriger vers une page de confirmation ou de succès
			
		} catch (Exception e) {
			// Gérer les exceptions et les erreurs
			model.addAttribute("error", "Erreur lors de la réservation : " + e.getMessage());
		}
		return "reservationCreneau";
	}
	
	
	@GetMapping("/creneaux-disponibles/{atelierId}")
	@ResponseBody
	public List<Creneau> getCreneauxDisponibles(@PathVariable Long atelierId) {
	    // Logique pour récupérer les créneaux disponibles de l'atelier spécifié
		System.out.println("/creneaux-disponibles/" + atelierId);
	    return creneauService.findAllCreneauxDisponibles(atelierId);
	}
	
	@PostMapping("/supprimer")
	public String supprimerReservation(@RequestParam("reservationId") Long id, Model model) {
		try {
			System.out.println(id);
			reservationService.supprimerReservation(id);
			model.addAttribute("error", "Reservation supprimee avec succes.");
		} catch (Exception e) {
			// Gérer les exceptions et les erreurs
			model.addAttribute("error", "Erreur lors de la réservation : " + e.getMessage());
		}
		return "reservations";
	}
	
	
}