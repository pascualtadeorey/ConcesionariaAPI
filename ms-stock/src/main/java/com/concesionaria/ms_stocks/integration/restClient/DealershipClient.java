package com.concesionaria.ms_stocks.integration.restClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.concesionaria.ms_stocks.dto.DealershipResponseDTO;

@FeignClient(name = "ms-dealership")
public interface DealershipClient {

    @GetMapping("/dealership/list")
    public List<DealershipResponseDTO> getAllDealerships();

    @GetMapping("/dealership/{id}")
    public DealershipResponseDTO getDealershipById(@PathVariable(name = "id") Long dealershipId);
}
