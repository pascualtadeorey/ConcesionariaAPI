package com.concesionaria.ms_stocks.integration.restClient;

import com.concesionaria.ms_stocks.dto.SellerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-seller")
public interface SellerClient {

    @GetMapping("/seller/list/{id}")
    SellerDTO getSeller(@PathVariable(value = "id") Long id);

    @GetMapping("seller/vendor/{vendorId}/belongs/dealership/{dealershipId}")
    boolean vendorBelongsToDealership(
            @PathVariable(value = "vendorId") Long vendorId,
            @PathVariable(value = "dealershipId") Long dealershipId);
}
