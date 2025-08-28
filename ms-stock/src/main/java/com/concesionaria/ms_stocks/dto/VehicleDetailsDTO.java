package com.concesionaria.ms_stocks.dto;

import com.concesionaria.ms_stocks.model.VehicleType;

public class VehicleDetailsDTO {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private VehicleType vehicleType;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public VehicleDetailsDTO() {
    }

    public VehicleDetailsDTO(Long id, String brand, String model, int year, VehicleType vehicleType, float price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vehicleType = vehicleType;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
