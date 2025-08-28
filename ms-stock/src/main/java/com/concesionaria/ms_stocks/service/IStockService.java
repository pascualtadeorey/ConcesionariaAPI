package com.concesionaria.ms_stocks.service;

import java.util.List;

import com.concesionaria.ms_stocks.dto.*;
import com.concesionaria.ms_stocks.exceptions.StockException;

public interface IStockService {

    public boolean existsVehicleInDealership(Long vehicleId, Long dealershipId);

    public int deliveryTime(Long vehicleId, Long dealershipId);

    public VehicleDetailsDTO findOrAddVehicle(VehicleDTO vehicleDTO);

    public List<StockResponseDTO> getAllStocks();

    public List<StockResponseDTO> getAllByDealership(Long id);

    public StockResponseDTO addStock(StockRequestDTO stockDTO);

    public void substractStock(Long vehicleID, Long dealershipId);

    public SaleResponseDTO processSale(SellRequestDTO sellRequestDTO);

}
