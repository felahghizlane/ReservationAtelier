package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Atelier;
import com.example.demo.repository.AtelierRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AtelierServiceImpl implements AtelierService {

    private final AtelierRepository atelierRepository;

    @Autowired
    public AtelierServiceImpl(AtelierRepository atelierRepository) {
        this.atelierRepository = atelierRepository;
    }

    @Override
    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll();
    }

    @Override
    public Atelier findAtelierById(Long id) {
    	return atelierRepository.findById(id).orElse(null);
    }
}
