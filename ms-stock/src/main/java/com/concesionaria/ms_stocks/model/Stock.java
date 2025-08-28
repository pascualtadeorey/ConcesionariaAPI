package com.concesionaria.ms_stocks.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stock", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"vehicleId", "dealershipId"})
})
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long vehicleId;
    private Long dealershipId;
    private int quantity;

    public Stock() {
    }

    public Stock(Long vehicleId, Long dealershipId, int quantity) {
        setVehicleId(vehicleId);
        setDealershipId(dealershipId);
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
