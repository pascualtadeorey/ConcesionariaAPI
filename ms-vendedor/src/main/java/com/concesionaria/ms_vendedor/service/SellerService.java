package com.concesionaria.ms_vendedor.service;

import com.concesionaria.ms_vendedor.dto.DealershipDTO;
import com.concesionaria.ms_vendedor.dto.SellerDTO;
import com.concesionaria.ms_vendedor.exception.SellerException;
import com.concesionaria.ms_vendedor.integration.restClient.DealershipClient;
import com.concesionaria.ms_vendedor.model.Seller;
import com.concesionaria.ms_vendedor.repository.SellerDAO;
import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService implements ISellerService {

    @Autowired
    private SellerDAO sellerDAO;

    @Autowired
    private DealershipClient dealershipClient;

    @Override
    public SellerDTO addSeller(SellerDTO sellerDTO) {
        validateSeller(sellerDTO);
        Seller seller = convertToEntity(sellerDTO);
        Seller sellerSaved = sellerDAO.save(seller);
        return convertToDTO(sellerSaved);
    }

    @Override
    public SellerDTO updateSeller(SellerDTO sellerDTO) {
        validateSeller(sellerDTO);
        Seller seller = sellerDAO.findById(sellerDTO.getId()).orElseThrow(() -> new SellerException("Vendedor con ID " + sellerDTO.getId() + " no encontrado.")); {
            seller.setName(sellerDTO.getName());
            seller.setLastName(sellerDTO.getLastName());
            seller.setIdentificationCode(sellerDTO.getIdentificationNumber());
            seller.setDealershipId(sellerDTO.getDealershipId());
            Seller sellerUpdated = sellerDAO.save(seller);
            return convertToDTO(sellerUpdated);
        }
    }

    public Boolean deleteSeller(Long id) {
        if (sellerDAO.existsById(id)) {
            sellerDAO.deleteById(id);
            return true;
        }else {
            throw new SellerException("Vendedor con ID " + id + " no encontrado.");
        }
    }

    @Override
    public SellerDTO getSellerByidentificationCode(String identificationCode) {
        Seller seller = sellerDAO.findSellerByIdentificationCode(identificationCode).orElseThrow(() -> new SellerException("Vendedor con ID " + identificationCode + " no encontrado."));
        return convertToDTO(seller);
    }

    @Override
    public SellerDTO getSellerById(Long id) {
        Seller seller = sellerDAO.findById(id).orElseThrow(() -> new SellerException("Vendedor con ID " + id + " no encontrado."));
        return convertToDTO(seller);
    }

    @Override
    public List<SellerDTO> getAllSellers() {
        Iterable<Seller> sellers = sellerDAO.findAll();
        List<SellerDTO> sellerDTOs = new ArrayList<>();

        for (Seller seller : sellers) {
            SellerDTO sellerDTO = convertToDTO(seller);
            sellerDTOs.add(sellerDTO);
        }
        return sellerDTOs;
    }

    private Seller convertToEntity(SellerDTO sellerDTO) {
        Seller seller = new Seller(
                sellerDTO.getName(),
                sellerDTO.getLastName(),
                sellerDTO.getIdentificationNumber(),
                sellerDTO.getDealershipId());
        return seller;
    }

    private SellerDTO convertToDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO(
                seller.getId(),
                seller.getName(),
                seller.getLastName(),
                seller.getIdentificationCode(),
                seller.getDealershipId());
        return sellerDTO;
    }

    @Override
    public boolean vendorBelongsToDealership(Long vendorId, Long dealershipId) {
        Seller vendor = sellerDAO.findById(vendorId).orElseThrow(() -> new SellerException("Vendedor con ID " + vendorId + " no encontrado."));

        return vendor.getDealershipId().equals(dealershipId);
    }

    private void validateSeller(SellerDTO sellerDTO) {
        if (sellerDAO.existsByIdentificationCode(sellerDTO.getIdentificationNumber())) {
            throw new SellerException("El vendedor con matricula " + sellerDTO.getIdentificationNumber() + " ya existe.");
        }
        if (sellerDTO.getName() == null || sellerDTO.getName().isEmpty()) {
            throw new SellerException("El nombre del vendedor es obligatorio.");
        }
        if (sellerDTO.getLastName() == null || sellerDTO.getLastName().isEmpty()){
            throw new SellerException("El apellido del vendedor es obligatorio.");
        }
        if (sellerDTO.getIdentificationNumber() == null || sellerDTO.getIdentificationNumber().matches("\\d{6}")){
            throw new SellerException("El numero de matricula debe tener 6 digitos");
        }
        if (sellerDTO.getDealershipId() == null || sellerDTO.getDealershipId() <= 0) {
            throw new SellerException("La concesionaria es obligatoria.");
        }

        try {
            DealershipDTO dealershipDTO = dealershipClient.getDealershipById(sellerDTO.getDealershipId());
        } catch (Exception e) {
            throw new SellerException("Concesionaria Inexistente");
        }
    }
}
