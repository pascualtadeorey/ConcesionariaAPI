package com.concesionaria.ms_workshop.dto;

public class WarrantyDTOResponse {
    private Long id;
    private String title;
    private Long vehicleTypeId;
    private float price;
    private int yearWarranty;
    
    public WarrantyDTOResponse() {
    }

    public WarrantyDTOResponse(Long id, String title, Long vehicleTypeId, int yearWarranty, float price) {
        this.id = id;
        this.title = title;
        this.vehicleTypeId = vehicleTypeId;
        this.price = price;
        this.yearWarranty = yearWarranty;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public int getYearWarranty() {
        return yearWarranty;
    }

    public void setYearWarranty(int yearWarranty) {
        this.yearWarranty = yearWarranty;
    }
}
