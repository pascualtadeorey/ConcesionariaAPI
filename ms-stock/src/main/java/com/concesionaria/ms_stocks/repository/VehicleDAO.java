package com.concesionaria.ms_stocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionaria.ms_stocks.model.Vehicle;

public interface VehicleDAO extends JpaRepository<Vehicle, Long> {
    public Vehicle findByBrandAndModelAndYear(String brand, String model, int year);
}
