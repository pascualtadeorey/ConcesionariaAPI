package com.concesionaria.ms_workshop.dto;

public class WorkshopEntryDTO {
    private int vin;
    private Long clientId;
    private Long dealershipId;
    private int entryDate;
    private int kilometers;
    private String diagnosis;
    private String serviceType;
    private Double amount;

    public WorkshopEntryDTO() {
    }

    public WorkshopEntryDTO(int vin, Long clientId, Long dealershipId, int entryDate, int kilometers, String diagnosis, String serviceType, Double amount) {
        setVin(vin);
        setClientId(clientId);
        setDealershipId(dealershipId);
        setEntryDate(entryDate);
        setKilometers(kilometers);
        setDiagnosis(diagnosis);
        setServiceType(serviceType);
        setAmount(amount);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(Long dealershipId) {
        this.dealershipId = dealershipId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(int entryDate) {
        this.entryDate = entryDate;
    }


    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {

        this.kilometers = kilometers;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }
}
