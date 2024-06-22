package com.devsu.customerservice.application;

import com.devsu.customerservice.application.dto.ClientCreateDTO;
import com.devsu.customerservice.application.dto.ClientResponseDTO;
import com.devsu.customerservice.application.dto.ClientUpdateDTO;
import com.devsu.customerservice.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientResponseDTO createClient(ClientCreateDTO client);

    List<ClientResponseDTO> getAllClients();

    ClientResponseDTO getClientById(Long clientId);

    ClientResponseDTO getByClientId(String clientId);

    ClientResponseDTO updateClient(Long clientId, ClientUpdateDTO clientUpdateDTO);

    ClientResponseDTO patchClient(Long clientId, ClientUpdateDTO clientUpdateDTO);

    void deleteClient(Long clientId);
}
