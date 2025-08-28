package com.concesionaria.ms_ventas.service;

import com.concesionaria.ms_ventas.dto.WarrantyDTORequest;
import com.concesionaria.ms_ventas.dto.WarrantyDTOResponse;

public interface IWarrantyService {

    WarrantyDTOResponse getWarranty(Long id);
}
