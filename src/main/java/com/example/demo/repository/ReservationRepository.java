package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  
    List<Reservation> findByCreneauId(Long creneauId);
}
