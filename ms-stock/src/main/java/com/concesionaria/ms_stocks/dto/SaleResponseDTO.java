package com.concesionaria.ms_stocks.dto;

// Este DTO informa el resultado de la operación de venta a ms-ventas.
public class SaleResponseDTO {
    private boolean success;
    private String message;
    private String deliveryDate;

    public SaleResponseDTO(boolean success, String message, String deliveryDate) {
        this.success = success;
        this.message = message;
        this.deliveryDate = deliveryDate;
    }

    // Getters y Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
