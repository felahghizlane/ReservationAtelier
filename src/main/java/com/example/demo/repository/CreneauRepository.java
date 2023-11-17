package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Creneau;

public interface CreneauRepository extends JpaRepository<Creneau, Long> {
	@Query("SELECT c FROM Creneau c WHERE c NOT IN (SELECT r.creneau FROM Reservation r)")
    List<Creneau> findCreneauxDisponibles();
}
