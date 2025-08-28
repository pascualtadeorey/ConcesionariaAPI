package com.concesionaria.ms_concesionaria.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.concesionaria.ms_concesionaria.model.Dealership;
import com.concesionaria.ms_concesionaria.repository.DealershipDAO;

import jakarta.annotation.PostConstruct;

@Configuration
public class BootstrapDealership {
    @Autowired
    DealershipDAO dao;

    @PostConstruct
    public void seed() {
        dao.save(new Dealership("Concesionaria Central", "calle central", "Argentina", "Buenos Aires", "Capital",
                "2025-01-01", 0));
        dao.save(new Dealership("Concesionaria sucursal 1", "calle 1", "Argentina", "Buenos Aires", "Moron",
                "2025-02-01", 10));
        dao.save(new Dealership("Concesionaria sucursal 2", "calle 2", "Argentina", "Buenos Aires", "Ciudadela",
                "2025-03-01", 20));
    }
}
