package com.concesionaria.ms_concesionaria.service;

import com.concesionaria.ms_concesionaria.dto.DealershipDTO;
import com.concesionaria.ms_concesionaria.exception.DealershipException;
import com.concesionaria.ms_concesionaria.model.Dealership;
import com.concesionaria.ms_concesionaria.repository.DealershipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealershipService implements IDealershipService {

    @Autowired
    private DealershipDAO dealershipDAO;

    @Override
    public DealershipDTO createDealership(DealershipDTO dealershipDTO) {
        validate(dealershipDTO);
        Dealership dealership = converToEntity(dealershipDTO);
        Dealership dealershipSaved = dealershipDAO.save(dealership);
        return converToDTO(dealershipSaved);
    }

    @Override
    public DealershipDTO updateDealership(DealershipDTO dealershipDTO) {
        return null;
    }

    @Override
    public DealershipDTO deleteDealership(DealershipDTO dealershipDTO) {
        return null;
    }

    @Override
    public List<DealershipDTO> getAllDealerships() {
        
        return dealershipDAO.findAll().stream().map(d 
        -> new DealershipDTO(
            d.getId(), 
            d.getName(), 
            d.getAddress(), 
            d.getCountry(), 
            d.getProvince(), 
            d.getCity(), 
            d.getyearOpen(), 
            d.getDistanceToCentral()
        )).toList();
    }

    @Override
    public DealershipDTO getDealershipById(Long id) {
       Dealership dealership = dealershipDAO.findById(id)
               .orElseThrow(() -> new DealershipException("La concesionaria con el id '" + id + "' no existe."));
       return converToDTO(dealership);
    }


    private Dealership converToEntity(DealershipDTO dealershipDTO) {
        Dealership dealership = new Dealership(
                dealershipDTO.getName(),
                dealershipDTO.getAddress(),
                dealershipDTO.getCountry(),
                dealershipDTO.getProvince(),
                dealershipDTO.getCity(),
                dealershipDTO.getYearOpen(),
                dealershipDTO.getDistanceToCentral()
        );
        return dealership;
    }

    private DealershipDTO converToDTO(Dealership dealership) {
        DealershipDTO dealershipDTO = new DealershipDTO(
                dealership.getId(),
                dealership.getName(),
                dealership.getAddress(),
                dealership.getCountry(),
                dealership.getProvince(),
                dealership.getCity(),
                dealership.getyearOpen(),
                dealership.getDistanceToCentral()
        );
        return dealershipDTO;
    }

    private void validate(DealershipDTO dealershipDTO) {
        if (dealershipDTO.getName() == null || dealershipDTO.getName().trim().isEmpty()) {
            throw new DealershipException("El nombre de la concesionaria no puede estar vacío.");
        }

        if (dealershipDTO.getAddress() == null || dealershipDTO.getAddress().trim().isEmpty()) {
            throw new DealershipException("La dirección no puede estar vacía.");
        }

        if (dealershipDTO.getCountry() == null || dealershipDTO.getCountry().trim().isEmpty()) {
            throw new DealershipException("El país no puede estar vacío.");
        }

        if (dealershipDTO.getProvince() == null || dealershipDTO.getProvince().trim().isEmpty()) {
            throw new DealershipException("La provincia no puede estar vacía.");
        }

        if (dealershipDTO.getCity() == null || dealershipDTO.getCity().trim().isEmpty()) {
            throw new DealershipException("La ciudad no puede estar vacía.");
        }

        int currentYear = java.time.Year.now().getValue();
        if (Integer.parseInt(dealershipDTO.getYearOpen()) < 1900 || Integer.parseInt(dealershipDTO.getYearOpen()) > currentYear) {
            throw new DealershipException("El año de apertura debe estar entre 1900 y " + currentYear);
        }

        if (dealershipDTO.getDistanceToCentral() <= 0) {
            throw new DealershipException("La distancia a la central debe ser un número positivo.");
        }

        // Validar que no exista otra con misma provincia y ciudad
        boolean existsSameLocation = dealershipDAO
                .existsByProvinceIgnoreCaseAndCityIgnoreCase(
                        dealershipDTO.getProvince(), dealershipDTO.getCity());

        if (existsSameLocation) {
            throw new DealershipException("Ya existe una concesionaria en la provincia '" +
                    dealershipDTO.getProvince() + "' y ciudad '" + dealershipDTO.getCity() + "'.");
        }

    }

}
