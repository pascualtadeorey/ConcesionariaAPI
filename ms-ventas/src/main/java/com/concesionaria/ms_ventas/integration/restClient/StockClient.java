package com.concesionaria.ms_ventas.integration.restClient;

import java.util.List;

import com.concesionaria.ms_ventas.dto.SellVehicleDTO;
import com.concesionaria.ms_ventas.dto.StockSaleResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.concesionaria.ms_ventas.dto.VehicleDetailsDTO;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-stock")
public interface StockClient {

    @GetMapping("/stock/exists/vehicle/{vehicleId}/dealership/{dealershipId}")
    public boolean existsVehicleInDealership(
            @PathVariable(name = "vehicleId") Long vehicleId,
            @PathVariable(name = "dealershipId") Long dealershipId);

    @GetMapping("/stock/exists/vehicle/{vehicleId}/dealership/central")
    public boolean existsVehicleInCentral(
            @PathVariable(name = "vehicleId") Long vehicleId);

    @GetMapping("/vehicle/list")
    public List<VehicleDetailsDTO> getAllVehicles();

    @GetMapping("/vehicle/{id}")
    public VehicleDetailsDTO getVehicleById(@PathVariable(name = "id") Long id);

    @PostMapping("/stock/process-sale")
    StockSaleResponseDTO processSale(@RequestBody SellVehicleDTO sellRequest);
}
