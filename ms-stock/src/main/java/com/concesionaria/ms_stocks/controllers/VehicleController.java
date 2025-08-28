package com.concesionaria.ms_stocks.controllers;

import com.concesionaria.ms_stocks.dto.VehicleDTO;
import com.concesionaria.ms_stocks.dto.VehicleDetailsDTO;
import com.concesionaria.ms_stocks.dto.VehicleTypeDTO;
import com.concesionaria.ms_stocks.service.VehicleService;
import com.concesionaria.ms_stocks.service.VehicleTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/list")
    public List<VehicleDetailsDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/save")
    public VehicleDetailsDTO save(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.findOrCreateVehicle(vehicleDTO);
    }

    @GetMapping("/{brand}/{model}/{year}")
    public VehicleDetailsDTO getVehicle(
            @PathVariable(value = "brand") String brand,
            @PathVariable(value = "model") String model,
            @PathVariable(value = "year") int year) {
        return vehicleService.getVehicle(brand, model, year);
    }

    @GetMapping("/{id}")
    public VehicleDetailsDTO getById(@PathVariable(value = "id") Long id) {
        return vehicleService.getVehicleById(id);
    }

    @PutMapping("/update")
    public VehicleDetailsDTO updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.updateVehicle(vehicleDTO);
    }
}
