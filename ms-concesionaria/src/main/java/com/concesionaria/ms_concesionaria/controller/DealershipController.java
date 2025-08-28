package com.concesionaria.ms_concesionaria.controller;

import com.concesionaria.ms_concesionaria.dto.DealershipDTO;
import com.concesionaria.ms_concesionaria.service.DealershipService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("dealership")
public class DealershipController {

    @Autowired
    private DealershipService dealershipService;

    @GetMapping("/list")
    public List<DealershipDTO> getAll() {
        return dealershipService.getAllDealerships();
    }

    @PostMapping("/create")
    public DealershipDTO save(@RequestBody DealershipDTO dealershipDTO) {
        return dealershipService.createDealership(dealershipDTO);
    }

    @GetMapping("/{id}")
    public DealershipDTO findById(@PathVariable(name = "id") Long id) {
        return dealershipService.getDealershipById(id);
    }
}
