package com.concesionaria.ms_stocks.dto;

public class StockDTO {
    private Long id;
    private Long vehicleId;
    private Long dealershipId;
    private int quantity;

    public StockDTO() {
    }

    public StockDTO(Long id, Long vehicleId, Long dealershipId, int quantity) {
        setId(id);
        setVehicleId(vehicleId);
        setDealershipId(dealershipId);
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int cantidad) {
        this.quantity = cantidad;
    }

    public Long getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(Long dealershipId) {
        this.dealershipId = dealershipId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
