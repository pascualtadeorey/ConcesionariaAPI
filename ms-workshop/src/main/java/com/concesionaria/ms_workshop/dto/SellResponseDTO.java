package com.concesionaria.ms_workshop.dto;

public class SellResponseDTO {
    private Long id;
    private VehicleDetailsDTO vehicleStock;
    private ClientDTO client;
    private WarrantyDTOResponse warranty;
    private String soldDate;
    private SellerDTO vendor;
    private DealershipDTO dealership;
    private String deliveryDate;
    private Float amount;
    private int vin;

    public SellResponseDTO() {
    }

    public SellResponseDTO(
        Long id, 
        VehicleDetailsDTO vehicleStock, 
        ClientDTO client, 
        WarrantyDTOResponse warranty, 
        String soldDate, 
        SellerDTO vendor, 
        DealershipDTO dealership, 
        String deliveryDate, 
        Float amount,
        int vin
    ) {
        this.id = id;
        this.vehicleStock = vehicleStock;
        this.client = client;
        this.warranty = warranty;
        this.soldDate = soldDate;
        this.vendor = vendor;
        this.dealership = dealership;
        this.deliveryDate = deliveryDate;
        this.amount = amount;
        this.vin = vin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleDetailsDTO getVehicleStock() {
        return vehicleStock;
    }

    public void setVehicleStock(VehicleDetailsDTO vehicleStock) {
        this.vehicleStock = vehicleStock;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public WarrantyDTOResponse getWarranty() {
        return warranty;
    }

    public void setWarranty(WarrantyDTOResponse warranty) {
        this.warranty = warranty;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    public SellerDTO getVendor() {
        return vendor;
    }

    public void setVendor(SellerDTO vendor) {
        this.vendor = vendor;
    }

    public DealershipDTO getDealership() {
        return dealership;
    }

    public void setDealership(DealershipDTO dealership) {
        this.dealership = dealership;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public int getVin() {
        return vin;
    }
    public void setVin(int vin) {
        this.vin = vin;
    }

}
