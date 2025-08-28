package com.concesionaria.ms_workshop.service;

import com.concesionaria.ms_workshop.dto.WorkshopEntryDTO;
import com.concesionaria.ms_workshop.dto.WorkshopEntryResponse;

import java.util.List;

public interface IWorkshopEntryService {
    public WorkshopEntryResponse creatWorkshopEntry(WorkshopEntryDTO workshopEntryDTO);
    public List<WorkshopEntryResponse> getAll();
}
