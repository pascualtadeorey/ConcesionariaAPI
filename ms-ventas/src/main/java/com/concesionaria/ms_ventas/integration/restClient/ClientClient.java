package com.concesionaria.ms_ventas.integration.restClient;

import com.concesionaria.ms_ventas.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-client")
public interface ClientClient {
@GetMapping("/client/{id}")
    ClientDTO getClient(@PathVariable(value = "id") Long id);
}
