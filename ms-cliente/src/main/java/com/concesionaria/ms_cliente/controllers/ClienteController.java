package com.concesionaria.ms_cliente.controllers;

import java.util.List;

import com.concesionaria.ms_cliente.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.concesionaria.ms_cliente.servicios.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("client")
public class ClienteController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return clientService.addUser(clientDTO);
    }

    @GetMapping("/getAllClients")
    public List<ClientDTO> getAllClients() {
        List<ClientDTO> allClients = clientService.getAllClients();
        return allClients;
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable(value = "id") Long id) {
        return clientService.getUserById(id);
    }

    @PutMapping("/update")
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        return clientService.updateUser(clientDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable(value = "id")Long id) {
        boolean deleted = clientService.deleteUser(id);
        return "Client id: " + id + " " + deleted;
    }

}
