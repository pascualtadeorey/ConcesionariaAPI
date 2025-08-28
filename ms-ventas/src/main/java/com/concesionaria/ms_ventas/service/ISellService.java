package com.concesionaria.ms_ventas.service;

import java.util.List;

import com.concesionaria.ms_ventas.dto.SellResponseDTO;
import com.concesionaria.ms_ventas.dto.SellVehicleDTO;

public interface ISellService {
    public SellResponseDTO createSell(SellVehicleDTO sellRequestDTO);

    public List<SellResponseDTO> getAllSells();

    SellResponseDTO findSellByVehicleVin(int vin);
}
