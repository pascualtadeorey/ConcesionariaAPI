package com.concesionaria.ms_vendedor.controller;

import com.concesionaria.ms_vendedor.dto.SellerDTO;
import com.concesionaria.ms_vendedor.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/create")
    public SellerDTO create(@RequestBody SellerDTO sellerDTO) {
        return sellerService.addSeller(sellerDTO);
    }

    @PutMapping("/update")
    public SellerDTO update(@RequestBody SellerDTO sellerDTO) {
        return sellerService.updateSeller(sellerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return sellerService.deleteSeller(id);
    }

    @GetMapping("/list")
    public List<SellerDTO> getAllSellers() {
        List<SellerDTO> sellers = sellerService.getAllSellers();
        return sellers;
    }

    @GetMapping("/lit/{identificationCode}")
    public SellerDTO getSellerByIdentificationCode(@PathVariable("identificationCode") String identificationCode) {
        return sellerService.getSellerByidentificationCode(identificationCode);
    }

    @GetMapping("/list/{id}")
    public SellerDTO getSellerById(@PathVariable("id") Long id) {
        return sellerService.getSellerById(id);
    }

    @GetMapping("/vendor/{vendorId}/belongs/dealership/{dealershipId}")
    public boolean vendorBelongsTodealership(
        @PathVariable("vendorId") Long vendorId,
        @PathVariable("dealershipId") Long dealershipId
    ) {
        return sellerService.vendorBelongsToDealership(vendorId, dealershipId);
    }
}
