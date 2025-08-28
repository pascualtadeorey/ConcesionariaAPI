package com.concesionaria.ms_ventas.controller;

import com.concesionaria.ms_ventas.dto.SellResponseDTO;
import com.concesionaria.ms_ventas.service.SellService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.concesionaria.ms_ventas.dto.SellVehicleDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @PostMapping("/create")
    public SellResponseDTO sellVehicle(@RequestBody SellVehicleDTO sellVehicleDTO) {
            return sellService.createSell(sellVehicleDTO);
    }

    @GetMapping("/list")
    public List<SellResponseDTO> getAllSells() {
        return sellService.getAllSells();
    }

    @GetMapping("/vehicle/{vin}")
    public SellResponseDTO findSellByVin(@PathVariable("vin") int vin) {
        return sellService.findSellByVehicleVin(vin);
    }
}
