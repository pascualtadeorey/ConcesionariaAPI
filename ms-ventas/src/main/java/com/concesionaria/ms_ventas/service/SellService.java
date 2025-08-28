package com.concesionaria.ms_ventas.service;

import com.concesionaria.ms_ventas.dto.*;
import com.concesionaria.ms_ventas.exception.ResourceNotFoundException;
import com.concesionaria.ms_ventas.exception.SellProcessException;
import com.concesionaria.ms_ventas.exception.ServiceUnavailableException;
import com.concesionaria.ms_ventas.integration.restClient.ClientClient;
import com.concesionaria.ms_ventas.integration.restClient.DealershipClient;
import com.concesionaria.ms_ventas.integration.restClient.SellerClient;
import com.concesionaria.ms_ventas.integration.restClient.StockClient;
import com.concesionaria.ms_ventas.model.SoldVehicle;
import com.concesionaria.ms_ventas.repository.SellDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellService implements ISellService {

    @Autowired
    private SellDAO sellDAO;

    @Autowired
    private WarrantyService warrantyService;

    @Autowired
    private ClientClient clientClient;

    @Autowired
    private SellerClient sellerClient;

    @Autowired
    private DealershipClient dealershipClient;

    @Autowired
    private StockClient stockClient;

    private static final Long CENTRAL_DEALERSHIP_ID = 1L;

    @Override
    @Transactional
    public SellResponseDTO createSell(SellVehicleDTO sellRequestDTO) {

        // Validaciones primitivas request
        validate(sellRequestDTO);

        // 1. Valido el vehículo si ya fue vendido.
        if (sellDAO.existsByVin(sellRequestDTO.getVin())) {
            throw new SellProcessException("El auto con VIN " + sellRequestDTO.getVin() + " ya fue vendido.");
        }

        // 2. Validación de cliente
        try {
            clientClient.getClient(sellRequestDTO.getClientId());
        } catch (FeignException.NotFound e) {
            // El servicio respondió, pero no encontró el recurso.
            throw new ResourceNotFoundException("El cliente con ID " + sellRequestDTO.getClientId() + " no existe.");
        } catch (FeignException e) {
            // El servicio no respondió (está caído, timeout, etc.).
            // Lanzamos nueva excepción 503.
            throw new ServiceUnavailableException("El servicio de Clientes no está disponible en este momento. Intente más tarde.");
        }

        // 3. Validación de la concesionaria
        if (sellRequestDTO.getDealershipId().equals(CENTRAL_DEALERSHIP_ID)) {
            throw new SellProcessException("No se puede vender desde la casa central.");
        }
        try {
            dealershipClient.getDealership(sellRequestDTO.getDealershipId());
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("La concesionaria con ID " + sellRequestDTO.getDealershipId() + " no existe.");
        } catch (FeignException e) {
            throw new ServiceUnavailableException("El servicio de concesionaria no está disponible en este momento. Intente más tarde.");
        }

        // 4. Validación del vendedor
        try {
            sellerClient.getSeller(sellRequestDTO.getVendorId());
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException("El vendedor con ID " + sellRequestDTO.getVendorId() + " no existe.");
        } catch (FeignException e) {
            throw new ServiceUnavailableException("El servicio de vendedores no está disponible en este momento. Intente más tarde.");
        }
        if (!sellerClient.vendorBelongsToDealership(sellRequestDTO.getVendorId(), sellRequestDTO.getDealershipId())) {
            throw new SellProcessException("El vendedor no pertenece a la concesionaria indicada.");
        }

        // 5. Llamar a ms-stock para procesar la venta.
        StockSaleResponseDTO stockResponse;
        try {
            stockResponse = stockClient.processSale(sellRequestDTO);
        } catch (FeignException.NotFound e) {
            throw new SellProcessException("No hay mas stock ni en sucursal ni en central");
        }
        catch (FeignException e) {
            // Captura errores de comunicación
            throw new ServiceUnavailableException("El servicio de stock no está disponible en este momento. Intente más tarde.");
        }

        // 7. registrar la venta.

        WarrantyDTOResponse warranty = warrantyService.getWarranty(sellRequestDTO.getWarrantyId());
        VehicleDetailsDTO vehicle = stockClient.getVehicleById(sellRequestDTO.getVehicleStockId());
        Float totalAmount = vehicle.getPrice() + warranty.getPrice();

        SoldVehicle soldVehicle = convertToEntity(sellRequestDTO, totalAmount);
        
        soldVehicle.setDeliveryDate(stockResponse.getDeliveryDate());

        SoldVehicle savedSoldVehicle = sellDAO.save(soldVehicle);
        return convertToDTO(savedSoldVehicle);
    }
    private SoldVehicle convertToEntity(SellVehicleDTO sellRequestDTO, Float amount) {
        SoldVehicle soldVehicle = new SoldVehicle(
                sellRequestDTO.getVehicleStockId(),
                sellRequestDTO.getClientId(),
                sellRequestDTO.getWarrantyId(),
                LocalDate.now().toString(),
                sellRequestDTO.getVendorId(),
                sellRequestDTO.getDealershipId(),
                sellRequestDTO.getDeliveryDate(),
                amount,
                sellRequestDTO.getVin());
        return  soldVehicle;
    }

    private SellResponseDTO convertToDTO(SoldVehicle soldVehicle) {

        ClientDTO client = clientClient.getClient(soldVehicle.getClientId());
        VehicleDetailsDTO vehicle = stockClient.getVehicleById(soldVehicle.getVehicleStockId());
        WarrantyDTOResponse warranty = warrantyService.getWarranty(soldVehicle.getWarrantyId());
        SellerDTO vendor = sellerClient.getSeller(soldVehicle.getVendorId());
        DealershipDTO dealership = dealershipClient.getDealership(soldVehicle.getDealershipId());

        SellResponseDTO sellResponseDTO = new SellResponseDTO(
                soldVehicle.getId(),
                vehicle,
                client,
                warranty,
                soldVehicle.getSoldDate(),
                vendor,
                dealership,
                soldVehicle.getDeliveryDate(),
                soldVehicle.getAmount(),
                soldVehicle.getVin());
        return sellResponseDTO;
    }

    @Override
    public List<SellResponseDTO> getAllSells() {
        List<SellResponseDTO> sells = new ArrayList<>();

        this.sellDAO.findAll().forEach(sell -> {
            sells.add(convertToDTO(sell));
        });
        return sells;
    }

    @Override
    public SellResponseDTO findSellByVehicleVin(int vin) {
        SoldVehicle soldVehicle = sellDAO.findByVin(vin);

        if (soldVehicle != null) {
            return convertToDTO(soldVehicle);
        }
        return null;
    }

    private void validate(SellVehicleDTO sellVehicleDTO){
        if (sellVehicleDTO.getClientId() == null) {
            throw new SellProcessException("El ID del cliente es obligatorio.");
        }
        if (sellVehicleDTO.getVendorId() == null) {
            throw new SellProcessException("El ID del vendedor es obligatorio.");
        }
        if (sellVehicleDTO.getDealershipId() == null) {
            throw new SellProcessException("El ID de la concesionaria es obligatorio.");
        }
        if (sellVehicleDTO.getVehicleStockId() == null) {
            throw new SellProcessException("El ID del vehículo en stock es obligatorio.");
        }

        if (sellVehicleDTO.getVin() < 999 || sellVehicleDTO.getVin() > 9999 ) {
            throw new SellProcessException("El VIN del vehículo debe contener 4 digitos.");
        }
    }
}
