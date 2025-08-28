package com.concesionaria.ms_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionaria.ms_ventas.model.Warranty;


public interface WarrantyDAO extends JpaRepository<Warranty, Long> {

    Long id(Long id);
}