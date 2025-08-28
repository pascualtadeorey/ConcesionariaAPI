package com.concesionaria.ms_workshop.repository;

import com.concesionaria.ms_workshop.model.WorkshopEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopEntryDAO extends JpaRepository<WorkshopEntry, Long> {
}
