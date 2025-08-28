package com.concesionaria.ms_vendedor.service;

import com.concesionaria.ms_vendedor.dto.SellerDTO;

import java.util.List;

public interface ISellerService {
    SellerDTO addSeller(SellerDTO sellerDTO);
    SellerDTO updateSeller(SellerDTO sellerDTO);
    List<SellerDTO> getAllSellers();
    boolean vendorBelongsToDealership(Long vendorId, Long dealershipId);
    SellerDTO getSellerByidentificationCode(String identificationCode);
    SellerDTO getSellerById(Long id);
}
