package com.concesionaria.ms_stocks.service;

import com.concesionaria.ms_stocks.dto.VehicleTypeDTO;
import com.concesionaria.ms_stocks.model.VehicleType;
import com.concesionaria.ms_stocks.repository.VehicleTypeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService implements IVehicleTypeService {

    @Autowired
    VehicleTypeDAO vehicleTypeDAO;

    @Override
    public VehicleTypeDTO addVehicleType(VehicleTypeDTO vehicleTypeDTO) {
        VehicleType vehicleType = convertToEntity(vehicleTypeDTO);
        VehicleType vehicleTypeSaved = vehicleTypeDAO.save(vehicleType);
        return convertToDTO(vehicleTypeSaved);
    }

    @Override
    public VehicleTypeDTO updateVehicleType(VehicleTypeDTO vehicleTypeDTO) {
        return null;
    }

    @Override
    public VehicleTypeDTO getVehicleTypeById(Long id) {
        VehicleType vehicleType = vehicleTypeDAO.findById(id).get();
        return convertToDTO(vehicleType);
    }

    @Override
    public List<VehicleTypeDTO> getAllVehicleTypes() {
        return List.of();
    }

    @Override
    public String deleteVehicleType(Long id) {
        return "";
    }

    private VehicleType convertToEntity(VehicleTypeDTO vehicleTypeDTO) {
        VehicleType vehicleType = new VehicleType(vehicleTypeDTO.getTypeName());
        return vehicleType;
    }

    private VehicleTypeDTO convertToDTO(VehicleType vehicleType) {
        VehicleTypeDTO vehicleTypeDTO = new VehicleTypeDTO(
                vehicleType.getId(),
                vehicleType.getTypeName());
        return vehicleTypeDTO;
    }
}
