package com.concesionaria.ms_stocks.dto;

public class VehicleTypeDTO {
    private Long id;
    private String typeName;

    public VehicleTypeDTO() {
    }

    public VehicleTypeDTO(Long id, String typeName) {
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
