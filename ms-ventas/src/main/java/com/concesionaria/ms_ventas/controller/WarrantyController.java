package com.concesionaria.ms_ventas.controller;

import com.concesionaria.ms_ventas.dto.SellVehicleDTO;
import com.concesionaria.ms_ventas.dto.WarrantyDTORequest;
import com.concesionaria.ms_ventas.dto.WarrantyDTOResponse;
import com.concesionaria.ms_ventas.service.WarrantyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("warranty")
public class WarrantyController {

    @Autowired
    private WarrantyService warrantyService;

    @GetMapping("/{id}")
    public WarrantyDTOResponse getWarrantyById(@PathVariable(name = "id") Long id)  {
        return warrantyService.getWarranty(id);
    }

}
