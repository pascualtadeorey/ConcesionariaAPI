package com.concesionaria.ms_cliente.bootstrap;

import com.concesionaria.ms_cliente.model.Client;
import com.concesionaria.ms_cliente.repository.ClientDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootstrapClient {

    @Autowired
    private ClientDAO clientDAO;

    @PostConstruct
    public void seed() {
        clientDAO.save(new Client("Agustin","Perez","1235643","test@gmail.com", "pilar"));
        clientDAO.save(new Client("Carlos","Guerra","345421234","test2@gmail.com", "Moreno"));
        clientDAO.save(new Client("Facundo","Rey","6534345","test3@gmail.com", "Palermo"));
    }
}
