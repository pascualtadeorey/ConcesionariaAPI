package com.concesionaria.ms_cliente.repository;

import com.concesionaria.ms_cliente.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientDAO extends JpaRepository<Client, Long> {
    boolean existsByDni(String dni);
    Optional<Client> findByDni(String dni);
}
