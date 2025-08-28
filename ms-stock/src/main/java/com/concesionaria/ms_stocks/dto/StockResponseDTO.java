package com.concesionaria.ms_stocks.dto;

public class StockResponseDTO {

    private Long id;
    private VehicleDetailsDTO vehicle;
    private DealershipResponseDTO dealership;
    private int quantity;

    public StockResponseDTO() {
    }

    public StockResponseDTO(Long id, VehicleDetailsDTO vehicle, DealershipResponseDTO dealership, int quantity) {
        this.id = id;
        this.vehicle = vehicle;
        this.dealership = dealership;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public VehicleDetailsDTO getVehicle() {
        return this.vehicle;
    }
    public DealershipResponseDTO getConcesionaria() {
        return dealership;
    }
    public int getQuantity() {
     return quantity;

    }

}
