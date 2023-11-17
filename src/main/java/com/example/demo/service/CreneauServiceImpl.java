package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CreneauRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.models.Creneau;
import com.example.demo.models.Reservation;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreneauServiceImpl implements CreneauService{

    private final CreneauRepository creneauRepository;
    private final ReservationRepository reservationRepository;


    @Autowired
    public CreneauServiceImpl(CreneauRepository creneauRepository, ReservationRepository reservationRepository) {
        this.creneauRepository = creneauRepository;
        this.reservationRepository = reservationRepository;
    }
    
    
    public List<Creneau> findAllCreneaux() {
        return creneauRepository.findAll();
    }

    public Creneau findCreneauById(Long id) {
        return creneauRepository.findById(id).orElse(null);
    }

    public Creneau saveCreneau(Creneau creneau) {
        return creneauRepository.save(creneau);
    }

    public void deleteCreneau(Long id) {
        creneauRepository.deleteById(id);
    }

	@Override
	public List<Creneau> findAllCreneauxDisponibles(Long atelierId) {
		List<Creneau> listAllCreneaux = creneauRepository.findAll();
    	List<Creneau> listDispo = new ArrayList<Creneau>();
    	if (atelierId != null) {
	    	if (listAllCreneaux != null) {
	    		for (Creneau creneau : listAllCreneaux) {
	    			if (creneau.getAtelier().getId().intValue() == atelierId.intValue()) {
	        			List<Reservation> reservations = reservationRepository.findByCreneauId(creneau.getId());
	        			if (reservations == null || reservations.isEmpty()) {
	        				listDispo.add(creneau);
	        			}
	    			}
	    		}
	    	}
    	}
        return listDispo;
	}

  
}
