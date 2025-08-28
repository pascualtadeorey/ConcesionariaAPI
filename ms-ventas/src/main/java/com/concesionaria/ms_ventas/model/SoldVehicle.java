package com.concesionaria.ms_ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SoldVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long vehicleStockId;
    private Long clientId;
    private Long warrantyId;
    private String SoldDate;
    private Long vendorId;
    private Long dealershipId;
    private String deliveryDate;
    private Float amount;
    private int vin;

    public SoldVehicle() {
    }

    public SoldVehicle(Long vehicleStockId, Long clientId, Long warrantyId, String SoldDate, Long vendorId, Long dealershipId, String deliveryDate, Float amount, int vin) {
        setVehicleStockId(vehicleStockId);
        setClientId(clientId);
        setWarrantyId(warrantyId);
        setSoldDate(SoldDate);
        setVendorId(vendorId);
        setDealershipId(dealershipId);
        setDeliveryDate(deliveryDate);
        setAmount(amount);
        setVin(vin);
    }

    public Long getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(Long dealershipId) {
        this.dealershipId = dealershipId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoldDate() {
        return SoldDate;
    }

    public void setSoldDate(String soldDate) {
        SoldDate = soldDate;
    }

    public Long getVehicleStockId() {
        return vehicleStockId;
    }

    public void setVehicleStockId(Long vehicleStockId) {
        this.vehicleStockId = vehicleStockId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(Long warrantyId) {
        this.warrantyId = warrantyId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getVin() {
        return vin;
    }
    public void setVin(int vin) {
        this.vin = vin;
    }

}
