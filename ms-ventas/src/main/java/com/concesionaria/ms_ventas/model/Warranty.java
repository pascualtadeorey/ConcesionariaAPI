package com.concesionaria.ms_ventas.model;


import jakarta.persistence.*;

@Entity
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Long vehicleTypeId;
    private int price;
    private int yearWarranty;

    public Warranty() {
    }

    public Warranty(String title, Long vehicleTypeId, int price, int yearWarranty) {
        setTitle(title);
        setVehicleTypeId(vehicleTypeId);
        setPrice(price);
        setYearWarranty(yearWarranty);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
