package com.concesionaria.ms_stocks.repository;

import com.concesionaria.ms_stocks.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface StockDAO extends JpaRepository<Stock, Long> {
    Optional<Stock> findByVehicleIdAndDealershipId(Long vehicleId, Long dealershipId);
    List<Stock> findByDealershipId(Long dealershipId);
}
