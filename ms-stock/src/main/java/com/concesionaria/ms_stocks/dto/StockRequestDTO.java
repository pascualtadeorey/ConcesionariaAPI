package com.concesionaria.ms_stocks.dto;

public class StockRequestDTO {
    private String brand;
    private String model;
    private Integer year;
    private Long vehicleTypeId;
    private Long dealershipId;
    private int quantity;
    private float price;

    
    public StockRequestDTO() {
    }
public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

  
    public StockRequestDTO(String brand, String model, Integer year, Long vehicleTypeId, Long dealershipId,
            int quantity, float price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vehicleTypeId = vehicleTypeId;
        this.dealershipId = dealershipId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Long getDealershipId() {
        return dealershipId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

}
