package com.concesionaria.ms_stocks.service;

import com.concesionaria.ms_stocks.dto.VehicleDTO;
import com.concesionaria.ms_stocks.dto.VehicleDetailsDTO;
import com.concesionaria.ms_stocks.dto.VehicleTypeDTO;
import com.concesionaria.ms_stocks.exceptions.ResourceNotFoundException;
import com.concesionaria.ms_stocks.model.Vehicle;
import com.concesionaria.ms_stocks.model.VehicleType;
import com.concesionaria.ms_stocks.repository.VehicleDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleDAO vehicleDAO;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Override
    public VehicleDetailsDTO findOrCreateVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicleFound = vehicleDAO.findByBrandAndModelAndYear(
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getYear());
        if (vehicleFound != null) {
            return convertToDTO(vehicleFound);
        }
        Vehicle vehicleSaved = vehicleDAO.save(convertToEntity(vehicleDTO));
        return convertToDTO(vehicleSaved);
    }

    @Override
    public VehicleDetailsDTO updateVehicle(VehicleDTO vehicleDTO)  {
        Vehicle vehicle = vehicleDAO.findByBrandAndModelAndYear(
                vehicleDTO.getBrand(),
                vehicleDTO.getModel(),
                vehicleDTO.getYear());

        if (vehicle == null) {
            throw new ResourceNotFoundException("No se puede actualizar. Vehículo no encontrado para: "
                    + vehicleDTO.getBrand() + " " + vehicleDTO.getModel() + " " + vehicleDTO.getYear());
        }

        //Busca el tipo de vehículo para asegurar que el ID es válido
        VehicleTypeDTO vehicleTypeDTO = vehicleTypeService.getVehicleTypeById(vehicleDTO.getVehicleTypeId());
        VehicleType vehicleType = new VehicleType(vehicleTypeDTO.getId(), vehicleTypeDTO.getTypeName());


        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setVehicleType(vehicleType);
        vehicle.setPrice(vehicleDTO.getPrice());

        Vehicle vehicleSaved = vehicleDAO.save(vehicle);

        return convertToDTO(vehicleSaved);
    }

    @Override
    public Boolean deleteVehicle(Long id) {
        if (vehicleDAO.existsById(id)) {
            vehicleDAO.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public VehicleDetailsDTO getVehicle(String brand, String model, int year) {
        Vehicle vehicle = vehicleDAO.findByBrandAndModelAndYear(brand, model, year);
        return convertToDTO(vehicle);
    }

    private Vehicle convertToEntity(VehicleDTO vehicleDTO) {
        VehicleTypeDTO vehicleTypeDTO = vehicleTypeService
                .getVehicleTypeById(vehicleDTO.getVehicleTypeId());

        VehicleType vehicleType = new VehicleType(
                vehicleTypeDTO.getId(),
                vehicleTypeDTO.getTypeName());
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setVehicleType(vehicleType);
        vehicle.setPrice(vehicleDTO.getPrice());
        return vehicle;
    }

    private VehicleDetailsDTO convertToDTO(Vehicle vehicle) {
        return new VehicleDetailsDTO(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getVehicleType(),
                vehicle.getPrice());
    }

    @Override
    public List<VehicleDetailsDTO> getAllVehicles() {
        vehicleDAO.findAll().forEach(v -> v.toString());
        return this.vehicleDAO.findAll().stream().map(v -> new VehicleDetailsDTO(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getYear(),
                v.getVehicleType(),
                v.getPrice())).toList();
    }

    @Override
    public VehicleDetailsDTO getVehicleById(Long id) {
        Vehicle vehicle = this.vehicleDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo con ID " + id + " no encontrado."));
        return convertToDTO(vehicle);
    }
}
