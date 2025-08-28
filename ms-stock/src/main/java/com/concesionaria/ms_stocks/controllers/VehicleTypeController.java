package com.concesionaria.ms_stocks.controllers;

import com.concesionaria.ms_stocks.dto.VehicleTypeDTO;
import com.concesionaria.ms_stocks.service.VehicleTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicletype")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @PostMapping("/save")
    public VehicleTypeDTO saveVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO) {
        return vehicleTypeService.addVehicleType(vehicleTypeDTO);
    }

    @GetMapping("/getAll")
    public List<VehicleTypeDTO> getAllVehicleTypes() {
        return vehicleTypeService.getAllVehicleTypes();
    }

    @PutMapping("/update")
    public VehicleTypeDTO updateVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO) {
        return vehicleTypeService.updateVehicleType(vehicleTypeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVehicleType(@PathVariable(value = "id") Long id) {
        String deleted = vehicleTypeService.deleteVehicleType(id);
        return deleted;
    }

    @GetMapping("/{id}")
    public VehicleTypeDTO getVehicleTypeById(@PathVariable(value = "id") Long id) {
        return vehicleTypeService.getVehicleTypeById(id);
    }
}
