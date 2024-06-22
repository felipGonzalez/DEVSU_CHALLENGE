package com.devsu.customerservice.application;

import com.devsu.customerservice.application.dto.ClientCreateDTO;
import com.devsu.customerservice.application.dto.ClientResponseDTO;
import com.devsu.customerservice.application.dto.ClientUpdateDTO;
import com.devsu.customerservice.application.mapper.ClientMapper;
import com.devsu.customerservice.domain.DomainException;
import com.devsu.customerservice.domain.model.Client;
import com.devsu.customerservice.domain.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImp implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public ClientResponseDTO createClient(ClientCreateDTO clientCreateDTO) {
        Client client = ClientMapper.toEntity(clientCreateDTO);
        client = clientRepository.save(client);
        return ClientMapper.toDTO(client);
    }
    public List<ClientResponseDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDTO getClientById(String clientId) {
        Client client = getClientEntityById(clientId);
        return ClientMapper.toDTO(client);
    }

    @Override
    public ClientResponseDTO updateClient(String clientId, ClientUpdateDTO clientUpdateDTO) {
        Client client = getClientEntityById(clientId);
        ClientMapper.updateFromDTO(clientUpdateDTO, client);
        client = clientRepository.save(client);
        return ClientMapper.toDTO(client);
    }

    @Override
    public ClientResponseDTO patchClient(String clientId, ClientUpdateDTO clientUpdateDTO) {
        Client client = getClientEntityById(clientId);

        if (clientUpdateDTO.getName() != null) {
            client.setName(clientUpdateDTO.getName());
        }
        if (clientUpdateDTO.getGender() != null) {
            client.setGender(clientUpdateDTO.getGender());
        }
        if (clientUpdateDTO.getAge() > 0) {
            client.setAge(clientUpdateDTO.getAge());
        }
        if (clientUpdateDTO.getIdentification() != null) {
            client.setIdentification(clientUpdateDTO.getIdentification());
        }
        if (clientUpdateDTO.getAddress() != null) {
            client.setAddress(clientUpdateDTO.getAddress());
        }
        if (clientUpdateDTO.getPhone() != null) {
            client.setPhone(clientUpdateDTO.getPhone());
        }
        if (clientUpdateDTO.getStatus() != null) {
            client.setStatus(clientUpdateDTO.getStatus());
        }

        client = clientRepository.save(client);
        return ClientMapper.toDTO(client);
    }

    @Override
    public void deleteClient(Long clientId) {

    }

    private Client getClientEntityById(String id) {
        return clientRepository.findByClientId(id)
                .orElseThrow(() -> new DomainException("Client not found with id: " + id));
    }
}
