package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ArtisanService;

@Controller
@RequestMapping("/artisans")
public class ArtisanController {

    private final ArtisanService artisanService;

    @Autowired
    public ArtisanController(ArtisanService artisanService) {
        this.artisanService = artisanService;
    }

    @GetMapping
    public String listArtisan(Model model) {
        // Logic to get artisan
        return "artisans"; // Nom du template Thymeleaf
    }
}
