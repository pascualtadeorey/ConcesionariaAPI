package com.concesionaria.ms_stocks.dto;

public class DealershipResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String country;
    private String province;
    private String city;
    private String yearOpen;
    private Integer distanceToCentral;

    public DealershipResponseDTO() {
    }

    public DealershipResponseDTO(Long id, String name, String address, String country, String province, String city,
            String yearOpen, Integer distanceToCentral) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.province = province;
        this.city = city;
        this.yearOpen = yearOpen;
        this.distanceToCentral = distanceToCentral;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getYearOpen() {
        return yearOpen;
    }

    public Integer getDistanceToCentral() {
        return distanceToCentral;
    }

}
