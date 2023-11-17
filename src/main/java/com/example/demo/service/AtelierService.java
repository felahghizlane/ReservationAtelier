package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Atelier;


public interface AtelierService {

	List<Atelier> getAllAteliers();
	
    Atelier findAtelierById(Long id);

}