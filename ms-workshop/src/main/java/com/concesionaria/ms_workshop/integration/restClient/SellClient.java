package com.concesionaria.ms_workshop.integration.restClient;

import com.concesionaria.ms_workshop.dto.SellResponseDTO;
import com.concesionaria.ms_workshop.dto.WarrantyResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-ventas")
public interface SellClient {

    @GetMapping("sell/vehicle/{vin}")
    SellResponseDTO findSellByVin(@PathVariable("vin") int vin);

    @GetMapping("/warranty/{id}")
    WarrantyResponseDTO findWarrantyById(@PathVariable("id") Long id);
}
