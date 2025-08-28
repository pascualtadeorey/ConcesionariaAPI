package com.concesionaria.ms_cliente.integration.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ms-stock")
public interface StockClient {
@GetMapping("/stocks")
    public List<String> getAllStocks();

}
