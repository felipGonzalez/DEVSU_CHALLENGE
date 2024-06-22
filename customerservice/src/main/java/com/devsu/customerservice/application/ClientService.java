package com.devsu.customerservice.application;

import com.devsu.customerservice.application.dto.ClientCreateDTO;
import com.devsu.customerservice.application.dto.ClientResponseDTO;
import com.devsu.customerservice.application.dto.ClientUpdateDTO;
import com.devsu.customerservice.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public ClientResponseDTO createClient(ClientCreateDTO client);

    public List<ClientResponseDTO> getAllClients();

    public ClientResponseDTO getClientById(String clientId);

    public ClientResponseDTO updateClient(String clientId, ClientUpdateDTO clientUpdateDTO);

    public ClientResponseDTO patchClient(String clientId, ClientUpdateDTO clientUpdateDTO);

    public void deleteClient(Long clientId);
}
