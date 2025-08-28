package com.concesionaria.ms_stocks.service;

import java.util.List;

import com.concesionaria.ms_stocks.dto.VehicleTypeDTO;

public interface IVehicleTypeService {
    public VehicleTypeDTO addVehicleType(VehicleTypeDTO vehicleTypeDTO);
    public VehicleTypeDTO updateVehicleType(VehicleTypeDTO vehicleTypeDTO);
    public VehicleTypeDTO getVehicleTypeById(Long id);
    public List<VehicleTypeDTO> getAllVehicleTypes();
    public String deleteVehicleType(Long id);
}
