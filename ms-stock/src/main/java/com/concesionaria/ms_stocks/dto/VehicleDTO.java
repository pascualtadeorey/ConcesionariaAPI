package com.concesionaria.ms_stocks.dto;

public class VehicleDTO {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private Long vehicleTypeId;
    private float price;

    

    public VehicleDTO() {
    }

    public VehicleDTO(String brand, String model, int year, Long vehicleTypeId, float price) {
        setBrand(brand);
        setModel(model);
        setYear(year);
        setVehicleTypeId(vehicleTypeId);
        setPrice(price);
    }
    
    public VehicleDTO(Long id, String brand, String model, int year, Long vehicleTypeId) {
        setId(id);
        setBrand(brand);
        setModel(model);
        setYear(year);
        setVehicleTypeId(vehicleTypeId);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
