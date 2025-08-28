package com.concesionaria.ms_workshop.dto;

public class ClientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String address;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String lastName, String dni, String email, String address) {
        setId(id);
        setName(name);
        setLastName(lastName);
        setDni(dni);
        setEmail(email);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
