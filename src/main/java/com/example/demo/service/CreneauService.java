package com.example.demo.service;
import java.util.List;

import com.example.demo.models.Creneau;


public interface CreneauService {


    public List<Creneau> findAllCreneauxDisponibles(Long atelierId);
   
    public List<Creneau> findAllCreneaux();

    public Creneau findCreneauById(Long id);

    public Creneau saveCreneau(Creneau creneau);

    public void deleteCreneau(Long id);
  
}
