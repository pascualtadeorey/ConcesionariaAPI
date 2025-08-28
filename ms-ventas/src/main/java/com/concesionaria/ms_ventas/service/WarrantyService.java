package com.concesionaria.ms_ventas.service;

import com.concesionaria.ms_ventas.dto.WarrantyDTORequest;
import com.concesionaria.ms_ventas.dto.WarrantyDTOResponse;
import com.concesionaria.ms_ventas.exception.ResourceNotFoundException;
import com.concesionaria.ms_ventas.model.Warranty;
import com.concesionaria.ms_ventas.repository.WarrantyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarrantyService implements IWarrantyService {

    @Autowired
    private WarrantyDAO warrantyDAO;

    @Override
    public WarrantyDTOResponse getWarranty(Long id) {
        Warranty warranty = warrantyDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Garantía con ID " + id + " no encontrada."));
        return converToDTO(warranty);
    }

   private WarrantyDTOResponse converToDTO(Warranty warranty) {
        WarrantyDTOResponse warrantyDTOResponse = new WarrantyDTOResponse(
                warranty.getId(),
                warranty.getTitle(),
                warranty.getVehicleTypeId(),
                warranty.getYearWarranty(),
                warranty.getPrice()
        );
        return warrantyDTOResponse;
    }
}
