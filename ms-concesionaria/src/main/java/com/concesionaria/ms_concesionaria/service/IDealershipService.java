package com.concesionaria.ms_concesionaria.service;

import com.concesionaria.ms_concesionaria.dto.DealershipDTO;

import java.util.List;

public interface IDealershipService {
    DealershipDTO createDealership(DealershipDTO dealershipDTO);
    DealershipDTO updateDealership(DealershipDTO dealershipDTO);
    DealershipDTO deleteDealership(DealershipDTO dealershipDTO);
    List<DealershipDTO> getAllDealerships();
    DealershipDTO getDealershipById(Long id);
}
