package com.concesionaria.ms_vendedor.dto;

public class DealershipDTO {
    private Long id;
    private String name;
    private String address;
    private String country;
    private String province;
    private String city;
    private String yearOpen;
    private Integer distanceToCentral;

    public DealershipDTO() {
    }

    public DealershipDTO(Long id, String name, String address, String country, String province, String city,
                         String yearOpen, Integer distanceToCentral) {
        setId(id);
        setName(name);
        setAddress(address);
        setCountry(country);
        setProvince(province);
        setCity(city);
        setYearOpen(yearOpen);
        setDistanceToCentral(distanceToCentral);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getIsCentral() {
        return this.getDistanceToCentral() == 0 ? "Casa Central" : "Sucursal";
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getYearOpen() {
        return yearOpen;
    }

    public void setYearOpen(String yearOpen) {
        this.yearOpen = yearOpen;
    }

    public Integer getDistanceToCentral() {
        return distanceToCentral;
    }

    public void setDistanceToCentral(Integer distanceToCentral) {
        this.distanceToCentral = distanceToCentral;
    }
}
