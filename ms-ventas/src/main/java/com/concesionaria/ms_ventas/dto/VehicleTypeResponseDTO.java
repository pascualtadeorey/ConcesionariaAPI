package com.concesionaria.ms_ventas.dto;

public class VehicleTypeResponseDTO {
    private Long id;
    private String typeName;

    public VehicleTypeResponseDTO(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }
}
