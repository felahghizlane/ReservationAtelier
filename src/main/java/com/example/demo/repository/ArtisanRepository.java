package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Artisan;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
   
}

