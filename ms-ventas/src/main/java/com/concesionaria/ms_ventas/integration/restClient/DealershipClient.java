package com.concesionaria.ms_ventas.integration.restClient;

import com.concesionaria.ms_ventas.dto.DealershipDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-dealership")
public interface DealershipClient {

    @GetMapping("/dealership/{id}")
    DealershipDTO getDealership(@PathVariable(value = "id") Long id);
}
