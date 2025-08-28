package com.concesionaria.ms_workshop.service;

import com.concesionaria.ms_workshop.Exception.WorkshopException;
import com.concesionaria.ms_workshop.dto.SellResponseDTO;
import com.concesionaria.ms_workshop.dto.WarrantyResponseDTO;
import com.concesionaria.ms_workshop.dto.WorkshopEntryDTO;
import com.concesionaria.ms_workshop.dto.WorkshopEntryResponse;
import com.concesionaria.ms_workshop.integration.restClient.SellClient;
import com.concesionaria.ms_workshop.model.ServiceType;
import com.concesionaria.ms_workshop.model.WorkshopEntry;
import com.concesionaria.ms_workshop.repository.WorkshopEntryDAO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class WorkshopEntryService implements IWorkshopEntryService {

    @Autowired
    private WorkshopEntryDAO workshopEntryDAO;

    @Autowired
    private SellClient sellClient;

    @Override
    public WorkshopEntryResponse creatWorkshopEntry(WorkshopEntryDTO workshopEntryDTO) {
        try {
            SellResponseDTO sellInfoDTO = sellClient.findSellByVin(workshopEntryDTO.getVin());
            if (sellInfoDTO == null) {
                throw new WorkshopException("No se encontró registro de venta para el vehículo.");
            }


            WarrantyResponseDTO warrantyResponseDTO;
            try {
                warrantyResponseDTO = sellClient.findWarrantyById(sellInfoDTO.getWarranty().getId());
            } catch (FeignException e) {
                throw new WorkshopException("Garantia con id: " + sellInfoDTO.getWarranty().getId() + " no encontrada.");
            }

            if (workshopEntryDTO.getServiceType().equalsIgnoreCase(ServiceType.WARRANTY.toString())) {
                int soldVehicleYear = yearOfSale(sellInfoDTO.getSoldDate());
                int warrantyEnd = soldVehicleYear +  warrantyResponseDTO.getYearWarranty();
                if (workshopEntryDTO.getEntryDate() < warrantyEnd) {
                    workshopEntryDTO.setAmount(0.0);
                }

            } else if (workshopEntryDTO.getServiceType().equalsIgnoreCase(ServiceType.REGULAR_SERVICE.toString())) {
                if (workshopEntryDTO.getAmount() == null || workshopEntryDTO.getAmount() <= 0) {
                    throw new IllegalArgumentException("Para un servicio regular, el monto debe ser un valor positivo.");
                }
            }

            WorkshopEntry workshopEntry = converToEntity(workshopEntryDTO);
            WorkshopEntry workshopEntrySaved = workshopEntryDAO.save(workshopEntry);
            return converToDTO(workshopEntrySaved);

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el ingreso al taller: " + e.getMessage(), e);
        }
    }

    @Override
    public List<WorkshopEntryResponse> getAll() {
        Iterable<WorkshopEntry> allWorkshops = workshopEntryDAO.findAll();
        List<WorkshopEntryResponse> workshopEntryResponses = new ArrayList<>();

        for (WorkshopEntry workshopEntry : allWorkshops) {
            WorkshopEntryResponse workshopEntryResponse = converToDTO(workshopEntry);
            workshopEntryResponses.add(workshopEntryResponse);
        }
        return workshopEntryResponses;
    }


    private WorkshopEntryResponse converToDTO(WorkshopEntry workshopEntry) {
        return new WorkshopEntryResponse(
                workshopEntry.getId(),
                workshopEntry.getVehicleVin(),
                workshopEntry.getClientId(),
                workshopEntry.getDealershipId(),
                workshopEntry.getEntryDate(),
                workshopEntry.getKilometers(),
                workshopEntry.getDiagnosis(),
                workshopEntry.getServiceType().toString(),
                workshopEntry.getAmount()
        );
    }

    private WorkshopEntry converToEntity(WorkshopEntryDTO workshopEntryDTO) {
        return new WorkshopEntry(
                workshopEntryDTO.getVin(),
                workshopEntryDTO.getClientId(),
                workshopEntryDTO.getDealershipId(),
                workshopEntryDTO.getEntryDate(),
                workshopEntryDTO.getKilometers(),
                workshopEntryDTO.getDiagnosis(),
                ServiceType.valueOf(workshopEntryDTO.getServiceType()),
                workshopEntryDTO.getAmount()
        );
    }

    private int yearOfSale(String date) {
        LocalDate fecha = LocalDate.parse(date);
        int year = fecha.getYear();
        return year;
    }
}


