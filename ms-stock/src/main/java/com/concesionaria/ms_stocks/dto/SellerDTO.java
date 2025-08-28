package com.concesionaria.ms_stocks.dto;

public class SellerDTO {
    private Long id;
    private String name;
    private String lastName;
    private String identificationNumber;
    private Long dealershipId;

    public SellerDTO() {
    }

    public SellerDTO(Long id, String name, String lastName, String identificationNumber, Long dealershipId) {
        setId(id);
        setName(name);
        setLastName(lastName);
        setIdentificationNumber(identificationNumber);
        setDealershipId(dealershipId);
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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
