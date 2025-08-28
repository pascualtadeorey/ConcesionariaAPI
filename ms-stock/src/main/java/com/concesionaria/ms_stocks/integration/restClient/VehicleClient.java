package com.concesionaria.ms_stocks.integration.restClient;

import com.concesionaria.ms_stocks.dto.VehicleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-vehicle")
public interface VehicleClient {

    @PostMapping("/vehicle/save")
    public VehicleDTO addVehicle(@RequestBody VehicleDTO request);

    @GetMapping("/vehicle/vin")
    public VehicleDTO isExistVehicle(@RequestBody Long vehicleId);
}
