package com.concesionaria.ms_concesionaria.repository;

import com.concesionaria.ms_concesionaria.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealershipDAO extends JpaRepository<Dealership, Long> {
    public boolean existsByProvinceIgnoreCaseAndCityIgnoreCase(String province, String city);
}
