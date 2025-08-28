package com.concesionaria.ms_stocks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeName;

    public VehicleType() {
    }

    public VehicleType(String typeName) {
        setTypeName(typeName);
    }

    public VehicleType(Long id, String typeName) {
        setId(id);
        setTypeName(typeName);
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
