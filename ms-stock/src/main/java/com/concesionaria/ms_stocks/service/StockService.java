package com.concesionaria.ms_stocks.service;

import com.concesionaria.ms_stocks.dto.*;
import com.concesionaria.ms_stocks.exceptions.InvalidStockOperationException;
import com.concesionaria.ms_stocks.exceptions.ResourceNotFoundException;
import com.concesionaria.ms_stocks.exceptions.StockException;
import com.concesionaria.ms_stocks.integration.restClient.DealershipClient;
import com.concesionaria.ms_stocks.integration.restClient.SellerClient;
import com.concesionaria.ms_stocks.model.Stock;
import com.concesionaria.ms_stocks.repository.StockDAO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService implements IStockService {

    @Autowired
    private StockDAO stockDAO;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private DealershipClient dealershipClient;

    @Autowired
    private SellerClient sellerClient;

    @Override
    public List<StockResponseDTO> getAllStocks() {
        List<StockResponseDTO> stocks = new ArrayList<>();

        try {

            stockDAO.findAll().forEach(stock -> {
                VehicleDetailsDTO vehicleDetailsDTO = this.vehicleService.getVehicleById(stock.getVehicleId());
                DealershipResponseDTO dealershipResponseDTO = this.dealershipClient
                        .getDealershipById(stock.getDealershipId());

                stocks.add(
                        new StockResponseDTO(
                                stock.getId(),
                                vehicleDetailsDTO,
                                dealershipResponseDTO,
                                stock.getQuantity()));

            });

            return stocks;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return List.of();
        }
    }

    @Override
    public StockResponseDTO addStock(StockRequestDTO stockDTORequest) {
        DealershipResponseDTO dealership;
        try {
            dealership = dealershipClient.getDealershipById(stockDTORequest.getDealershipId());
        } catch (FeignException e) {
            throw new ResourceNotFoundException("Concesionaria con ID " + stockDTORequest.getDealershipId() + " inexistente.");
        }

        if (stockDTORequest.getQuantity() <= 0) {
            throw new InvalidStockOperationException("No se puede ingresar un stock 0 o negativo.");
        }

        String brand = stockDTORequest.getBrand().substring(0, 1).toUpperCase()
                + stockDTORequest.getBrand().substring(1).toLowerCase();
        String model = stockDTORequest.getModel().substring(0, 1).toUpperCase()
                + stockDTORequest.getModel().substring(1).toLowerCase();
        VehicleDetailsDTO vehicle = vehicleService.findOrCreateVehicle(new VehicleDTO(
                brand,
                model,
                stockDTORequest.getYear(),
                stockDTORequest.getVehicleTypeId(),
                stockDTORequest.getPrice()));

        Optional<Stock> optionalStock = stockDAO.findByVehicleIdAndDealershipId(vehicle.getId(), dealership.getId());

        Stock stock;
        if (optionalStock.isPresent()) {
            stock = optionalStock.get();
            stock.setQuantity(stock.getQuantity() + stockDTORequest.getQuantity());
        } else {
            stock = new Stock(vehicle.getId(), dealership.getId(), stockDTORequest.getQuantity());
        }

        stock = stockDAO.save(stock);
        return new StockResponseDTO(
                stock.getId(),
                vehicle,
                dealership,
                stock.getQuantity());
    }

    @Override
    public void substractStock(Long vehicleID, Long dealershipId) {
        Stock stock = stockDAO.findByVehicleIdAndDealershipId(vehicleID, dealershipId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock no encontrado para el vehículo ID " + vehicleID + " en la concesionaria ID " + dealershipId));

        if (stock.getQuantity() > 0) {
            stock.setQuantity(stock.getQuantity() - 1);
            stockDAO.save(stock);
        } else {
            throw new InvalidStockOperationException("No hay stock suficiente para el vehículo ID " + vehicleID);
        }
    }

    @Override
    public SaleResponseDTO processSale(SellRequestDTO sellRequestDTO) {

        vehicleService.getVehicleById(sellRequestDTO.getVehicleStockId());


        // 2. Lógica de Stock y cálculo de fecha de entrega
        Long vehicleId = sellRequestDTO.getVehicleStockId();
        Long dealershipId = sellRequestDTO.getDealershipId();
        String deliveryDate;

        if (this.existsVehicleInDealership(vehicleId, dealershipId)) {
            deliveryDate = LocalDate.now().toString();
            this.substractStock(vehicleId, dealershipId);
        } else if (this.existsVehicleInDealership(vehicleId, 1L)) { // Asumimos 1L es la central
            DealershipResponseDTO dealership;
            try {
                dealership = dealershipClient.getDealershipById(dealershipId);
            } catch (FeignException.NotFound e) {
                throw new ResourceNotFoundException("La concesionaria sucursal con ID " + dealershipId + " no fue encontrada.");
            }
            LocalDate deliveryDateUpdated = LocalDate.now().plusDays(dealership.getDistanceToCentral());
            deliveryDate = deliveryDateUpdated.toString();
            this.substractStock(vehicleId, 1L); // Descontar de la central
        } else {
            throw new ResourceNotFoundException("Vehículo sin stock ni en sucursal ni en la central.");
        }
        return new SaleResponseDTO(true, "Venta procesada", deliveryDate);
    }

    @Override
    public VehicleDetailsDTO findOrAddVehicle(VehicleDTO vehicleDTO) {
        return this.vehicleService.findOrCreateVehicle(vehicleDTO);
    }

    @Override
    public List<StockResponseDTO> getAllByDealership(Long id) {
        List<StockResponseDTO> stocks = new ArrayList<>();

        try {

            stockDAO.findByDealershipId(id).stream().forEach(stock -> {
                VehicleDetailsDTO vehicleDetailsDTO = this.vehicleService.getVehicleById(stock.getVehicleId());
                DealershipResponseDTO dealershipResponseDTO = this.dealershipClient
                        .getDealershipById(stock.getDealershipId());

                stocks.add(
                        new StockResponseDTO(
                                stock.getId(),
                                vehicleDetailsDTO,
                                dealershipResponseDTO,
                                stock.getQuantity()));

            });

            return stocks;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return List.of();
        }
    }

    @Override
    public boolean existsVehicleInDealership(Long vehicleId, Long dealershipId) {
        Optional<Stock> optional = this.stockDAO.findByVehicleIdAndDealershipId(vehicleId, dealershipId);
        return optional.isPresent() && optional.get().getQuantity() > 0;
    }

    @Override
    public int deliveryTime(Long vehicleId, Long dealershipId) {
        return 0;
    }
}
