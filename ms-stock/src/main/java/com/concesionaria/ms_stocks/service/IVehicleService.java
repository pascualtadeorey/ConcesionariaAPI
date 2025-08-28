package com.concesionaria.ms_stocks.service;

import java.util.List;

import com.concesionaria.ms_stocks.dto.VehicleDTO;
import com.concesionaria.ms_stocks.dto.VehicleDetailsDTO;

public interface IVehicleService {
    VehicleDetailsDTO findOrCreateVehicle(VehicleDTO vehicleDTO);

    List<VehicleDetailsDTO> getAllVehicles();

    VehicleDetailsDTO updateVehicle(VehicleDTO vehicleDTO) throws Exception;

    Boolean deleteVehicle(Long id);

    VehicleDetailsDTO getVehicle(String brand, String model, int year);

    VehicleDetailsDTO getVehicleById(Long id);
}
