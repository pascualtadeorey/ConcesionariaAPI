package com.concesionaria.ms_stocks.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.concesionaria.ms_stocks.model.Vehicle;
import com.concesionaria.ms_stocks.model.VehicleType;
import com.concesionaria.ms_stocks.repository.VehicleDAO;
import com.concesionaria.ms_stocks.repository.VehicleTypeDAO;

import jakarta.annotation.PostConstruct;

@Configuration
public class VehicleBoostrap {
    @Autowired
    private VehicleDAO vehicleDAO;

    @Autowired
    private VehicleTypeDAO vehicleTypeDAO;

    @PostConstruct
    public void seed() {
        VehicleType autoTipo = vehicleTypeDAO.save(new VehicleType("Auto"));
        VehicleType camionetaTipo = vehicleTypeDAO.save(new VehicleType("Camioneta"));

        vehicleDAO.save(new Vehicle("Ford", "Fiesta", 2015, autoTipo, 2000));
        vehicleDAO.save(new Vehicle("Peugeot", "208", 2010, autoTipo, 3500));
        vehicleDAO.save(new Vehicle("Fiat", "Chronos", 2025, autoTipo, 1500));
        vehicleDAO.save(new Vehicle("Toyota", "Hilux", 2010, camionetaTipo, 5000));
        vehicleDAO.save(new Vehicle("Ford", "F-100", 1990, camionetaTipo, 4000));
    }

}
