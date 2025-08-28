package com.concesionaria.ms_stocks.dto;

public class SellRequestDTO {
    private Long vehicleStockId;
    private Long clientId;
    private Long warrantyId;
    private Long vendorId;
    private Long dealershipId;
    private String deliveryDate;
    private int vin;

    public SellRequestDTO() {
    }

    public SellRequestDTO(Long vehicleStockId, Long clientId, Long warrantyId, Long vendorId, Long dealershipId,
                          String deliveryDate, int vin) {
        this.vehicleStockId = vehicleStockId;
        this.clientId = clientId;
        this.warrantyId = warrantyId;
        this.vendorId = vendorId;
        this.dealershipId = dealershipId;
        this.deliveryDate = deliveryDate;
        this.vin = vin;
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
