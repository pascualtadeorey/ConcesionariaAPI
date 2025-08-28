package com.concesionaria.ms_cliente.servicios;

import java.util.ArrayList;
import java.util.List;

import com.concesionaria.ms_cliente.dto.ClientDTO;
import com.concesionaria.ms_cliente.exception.ClientException;
import com.concesionaria.ms_cliente.exception.DuplicateDniException;
import com.concesionaria.ms_cliente.model.Client;
import com.concesionaria.ms_cliente.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concesionaria.ms_cliente.integration.restclient.StockClient;

@Service
public class ClientService implements IClientService {
    @Autowired 
    private StockClient stockClient;

    @Autowired
    private ClientDAO clientDAO;



    public List<String> getAllStocks()
    {
        return this.stockClient.getAllStocks();
    }

    @Override
    public ClientDTO addUser(ClientDTO clientDTO) {
        validateClient(clientDTO);
        if (clientDAO.existsByDni(clientDTO.getDni())) {
            // Si ya existe, lanzamos una excepción específica para este caso.
            throw new DuplicateDniException("Ya existe un cliente con el DNI " + clientDTO.getDni());
        }
        Client client = convertToEntity(clientDTO);
        Client clientSaved = clientDAO.save(client);
        return convertToResponseDTO(clientSaved);
    }

    @Override
    public ClientDTO updateUser(ClientDTO clientDTO) {
        validateClient(clientDTO);
        if (clientDAO.existsById(clientDTO.getId())) {
            Client client = clientDAO.findById(clientDTO.getId())
                    .orElseThrow(() -> new ClientException("No se puede actualizar. Cliente con ID " + clientDTO.getId() + " no encontrado."));
            client.setName(clientDTO.getName());
            client.setLastName(clientDTO.getLastName());
            client.setEmail(clientDTO.getEmail());
            client.setDni(clientDTO.getDni());
            client.setAddress(clientDTO.getAddress());
            clientDAO.save(client);
            return clientDTO;
        } else {
            System.out.println("El cliente no existe");
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        if (clientDAO.existsById(id)) {
            clientDAO.deleteById(id);
            return true;
        } else {
            throw new ClientException("No se puede eliminar. Cliente con ID " + id + " no encontrado.");
        }
    }

    @Override
    public ClientDTO getUserById(Long id) {
        Client client = clientDAO.findById(id)
                .orElseThrow(() -> new ClientException("Cliente con DNI " + id + " no encontrado."));
        return convertToResponseDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        Iterable<Client> allClients = clientDAO.findAll();
        List<ClientDTO> allClientsDTO = new ArrayList<>();

        for (Client client : allClients) {
            ClientDTO clientDTOResponse = new ClientDTO(
                    client.getId(),
                    client.getName(),
                    client.getLastName(),
                    client.getDni(),
                    client.getEmail(),
                    client.getAddress()
            );
            allClientsDTO.add(clientDTOResponse);
        }
        return allClientsDTO;
    }


    private Client convertToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setDni(clientDTO.getDni());
        client.setEmail(clientDTO.getEmail());
        client.setAddress(clientDTO.getAddress());
        return client;
    }

    private ClientDTO convertToResponseDTO(Client client) {
        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(client.getId());
        clientDTOResponse.setName(client.getName());
        clientDTOResponse.setLastName(client.getLastName());
        clientDTOResponse.setDni(client.getDni());
        clientDTOResponse.setEmail(client.getEmail());
        clientDTOResponse.setAddress(client.getAddress());
        return clientDTOResponse;
    }

    private void validateClient(ClientDTO clientDTO) {
        // VALIDACIONES BÁSICAS
        if (clientDTO.getName() == null || clientDTO.getName().trim().isEmpty()) {
            throw new ClientException("El nombre no puede estar vacío.");
        }

        if (clientDTO.getLastName() == null || clientDTO.getLastName().trim().isEmpty()) {
            throw new ClientException("El apellido no puede estar vacío.");
        }

        if (clientDTO.getDni() == null || !clientDTO.getDni().matches("\\d{8}")) {
            throw new ClientException("El DNI debe tener exactamente 8 dígitos numéricos.");
        }

        if (clientDTO.getEmail() == null || !clientDTO.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            throw new ClientException("El correo electrónico no es válido.");
        }

        if (clientDTO.getAddress() == null || clientDTO.getAddress().trim().isEmpty()) {
            throw new ClientException("La dirección no puede estar vacía.");
        }
    }


}
