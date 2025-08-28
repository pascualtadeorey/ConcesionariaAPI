package com.concesionaria.ms_cliente.servicios;

import com.concesionaria.ms_cliente.dto.ClientDTO;

import java.util.List;

public interface IClientService {
     ClientDTO addUser(ClientDTO clientDTO);
     ClientDTO updateUser(ClientDTO clientDTOResponse);
     Boolean deleteUser(Long id);
     ClientDTO getUserById(Long id);
     List<ClientDTO> getAllClients();

}
