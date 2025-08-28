package com.concesionaria.ms_ventas.dto;


public class VehicleDetailsDTO {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private VehicleTypeResponseDTO vehicleType;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public VehicleDetailsDTO() {
    }

    public VehicleDetailsDTO(Long id, String brand, String model, int year, VehicleTypeResponseDTO vehicleType, float price) {
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

    public VehicleTypeResponseDTO getVehicleType() {
        return vehicleType;
    }

}
