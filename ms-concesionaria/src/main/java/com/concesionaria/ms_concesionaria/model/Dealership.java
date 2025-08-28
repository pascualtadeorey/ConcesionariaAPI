package com.concesionaria.ms_concesionaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "concesionarias", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "province", "city" })
})
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String country;
    private String province;
    private String city;
    private String yearOpen;
    private Integer distanceToCentral;

    public Dealership() {
    }

    public Dealership(String name, String address, String country, String province, String city, String yearOpen,
            Integer distanceToCentral) {
        setName(name);
        setAddress(address);
        setCountry(country);
        setProvince(province);
        setCity(city);
        setyearOpen(yearOpen);
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getyearOpen() {
        return yearOpen;
    }

    public void setyearOpen(String yearOpen) {
        this.yearOpen = yearOpen;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getDistanceToCentral() {
        return distanceToCentral;
    }

    public void setDistanceToCentral(Integer distanceToCentral) {
        if (distanceToCentral < 0) {
            throw new IllegalArgumentException("Valor de distancia ilegal");
        }
        this.distanceToCentral = distanceToCentral;
    }
}
