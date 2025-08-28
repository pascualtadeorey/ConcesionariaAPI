package com.concesionaria.ms_ventas.bootstrap;

import com.concesionaria.ms_ventas.repository.WarrantyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.concesionaria.ms_ventas.model.Warranty;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class initData {

    @Autowired
    private WarrantyDAO warrantyDAO;

    @PostConstruct
    public void seed() {

        // Garantias
        warrantyDAO.save(new Warranty("Garantia Para Autos - Basica", 1L, 1000,  2));
        warrantyDAO.save(new Warranty("Garantia Para Camionetas- Basica", 2L, 1500 ,  1));
    }

}
