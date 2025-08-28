package com.concesionaria.ms_ventas.dto;

// DTO para deserializar la respuesta de ms-stock/process-sale
public class StockSaleResponseDTO {
    private boolean success;
    private String message;
    private String deliveryDate;

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
