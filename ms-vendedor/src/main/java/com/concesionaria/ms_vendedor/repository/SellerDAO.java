package com.concesionaria.ms_vendedor.repository;

import com.concesionaria.ms_vendedor.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerDAO extends JpaRepository<Seller, Long> {
    boolean existsByIdentificationCode(String identificationCode);
    Optional<Seller> findSellerByIdentificationCode(String identificationCode);
}
