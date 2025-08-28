package com.concesionaria.ms_vendedor.integration.restClient;

import com.concesionaria.ms_vendedor.dto.DealershipDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-dealership")
public interface DealershipClient {
    @GetMapping("/dealership/{id}")
    public DealershipDTO getDealershipById(@PathVariable(name = "id") Long id);
}
