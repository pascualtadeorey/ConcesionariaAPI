package com.concesionaria.ms_workshop.controller;

import com.concesionaria.ms_workshop.dto.WorkshopEntryDTO;
import com.concesionaria.ms_workshop.dto.WorkshopEntryResponse;
import com.concesionaria.ms_workshop.service.WorkshopEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workshop")
public class WorkshopController {

    @Autowired
    private WorkshopEntryService workshopEntryService;

    @PostMapping("/create")
    public WorkshopEntryResponse createWorkshopEntry(@RequestBody WorkshopEntryDTO workshopEntryDTO) {
        return workshopEntryService.creatWorkshopEntry(workshopEntryDTO);
    }

    @GetMapping("/list")
    public List<WorkshopEntryResponse> listWorkshops() {
        List<WorkshopEntryResponse> allWorkshops = workshopEntryService.getAll();
        return allWorkshops;
    }

}
