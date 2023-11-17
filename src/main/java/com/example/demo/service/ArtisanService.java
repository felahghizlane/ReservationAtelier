package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ArtisanRepository;


@Service
public class ArtisanService {

    private final ArtisanRepository artisanRepository;

    @Autowired
    public ArtisanService(ArtisanRepository artisanRepository) {
        this.artisanRepository = artisanRepository;
    }

    
}