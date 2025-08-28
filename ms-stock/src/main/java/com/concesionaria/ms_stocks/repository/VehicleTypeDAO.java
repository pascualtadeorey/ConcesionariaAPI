package com.concesionaria.ms_stocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionaria.ms_stocks.model.VehicleType;

public interface VehicleTypeDAO extends JpaRepository<VehicleType, Long> {
}
