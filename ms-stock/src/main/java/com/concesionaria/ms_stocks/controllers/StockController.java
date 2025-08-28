package com.concesionaria.ms_stocks.controllers;

import com.concesionaria.ms_stocks.dto.SaleResponseDTO;
import com.concesionaria.ms_stocks.dto.SellRequestDTO;
import com.concesionaria.ms_stocks.dto.StockRequestDTO;
import com.concesionaria.ms_stocks.dto.StockResponseDTO;
import com.concesionaria.ms_stocks.exceptions.StockException;
import com.concesionaria.ms_stocks.service.StockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/list")
    public List<StockResponseDTO> getAll() {
        return stockService.getAllStocks();
    }

    @GetMapping("/exists/vehicle/{vehicleId}/dealership/{dealershipId}")
    public boolean existsVehicleInDealership(
            @PathVariable("vehicleId") Long vehicleId,
            @PathVariable("dealershipId") Long dealershipId) {
        return stockService.existsVehicleInDealership(vehicleId, dealershipId);
    }

    @GetMapping("/exists/vehicle/{vehicleId}/dealership/central")
    public boolean existsVehicleInCentral(
            @PathVariable("vehicleId") Long vehicleId) {
        Long centralId = 1L;
        return stockService.existsVehicleInDealership(vehicleId, centralId);
    }

    @PostMapping("/substract/vehicle/{vehicleId}/dealership/{dealershipId}")
    public void substractVehicleFromStockOfDealership(
            @PathVariable(name = "vehicleId") Long vehicleId,
            @PathVariable(name = "dealershipId") Long dealershipId) {
            stockService.substractStock(vehicleId, dealershipId);
    }

    @PostMapping("/substract/vehicle/{vehicleId}/dealership/central")
    public void substractVehicleFromStockOfCentral(
            @PathVariable(name = "vehicleId") Long vehicleId) {
            Long centralId = 1L;
            stockService.substractStock(vehicleId, centralId);
        }

    @GetMapping("/list/{id}")
    public List<StockResponseDTO> getByDealership(@PathVariable(name = "id") Long id) {
        return stockService.getAllByDealership(id);
    }

    @PostMapping("/create")
    public StockResponseDTO createStock(@RequestBody StockRequestDTO stockRequestDTO) {
            return stockService.addStock(stockRequestDTO);
    }

    @PostMapping("/process-sale")
    public SaleResponseDTO processSale(@RequestBody SellRequestDTO sellRequestDTO) {

            return stockService.processSale(sellRequestDTO);

    }

}
