package com.concesionaria.ms_workshop.model;

import jakarta.persistence.*;


@Entity
public class WorkshopEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int vehicleVin;
    private Long clientId;
    private Long dealershipId;
    private int entryDate;
    private int kilometers;
    private String diagnosis;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType;
    private Double amount;

    public WorkshopEntry() {
    }

    public WorkshopEntry(int vehicleVin, Long clientId, Long dealershipId, int entryDate, int kilometers, String diagnosis, ServiceType serviceType, Double amount) {
        setVehicleVin(vehicleVin);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public int getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(int vehicleId) {
        this.vehicleVin = vehicleId;
    }
}
