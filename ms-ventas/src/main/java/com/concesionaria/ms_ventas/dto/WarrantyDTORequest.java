package com.concesionaria.ms_ventas.dto;

public class WarrantyDTORequest {
    private String title;
    private Long vehicleTypeId;
    private float price;
    private int yearWarranty;

    public WarrantyDTORequest() {
    }

    public WarrantyDTORequest(String title, float price, int yearWarranty) {
        this.title = title;
        this.price = price;
        this.yearWarranty = yearWarranty;
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
