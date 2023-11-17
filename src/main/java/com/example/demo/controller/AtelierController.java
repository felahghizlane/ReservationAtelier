package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AtelierService;

@Controller
public class AtelierController {

    private final AtelierService atelierService;

    @Autowired
    public AtelierController(AtelierService atelierService) {
        this.atelierService = atelierService;
    }

    @GetMapping("/ateliers")
    public String showAtelierList(Model model) {
        model.addAttribute("ateliers", atelierService.getAllAteliers());
        return "ateliers"; 
    }
}
