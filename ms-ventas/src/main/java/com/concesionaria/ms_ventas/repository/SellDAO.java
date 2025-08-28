package com.concesionaria.ms_ventas.repository;

import com.concesionaria.ms_ventas.model.SoldVehicle;
import org.springframework.data.repository.CrudRepository;

public interface SellDAO extends CrudRepository<SoldVehicle, Long> {
    boolean existsByVin(int vin);

    SoldVehicle findByVin(int vin);
}
