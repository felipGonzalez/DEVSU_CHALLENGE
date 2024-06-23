package com.devsu.customerservice.application;

import com.devsu.customerservice.application.dto.ClientCreateDTO;
import com.devsu.customerservice.application.dto.ClientResponseDTO;
import com.devsu.customerservice.application.dto.ClientUpdateDTO;
import com.devsu.customerservice.application.mapper.ClientMapper;
import com.devsu.customerservice.domain.DomainException;
import com.devsu.customerservice.domain.model.Client;
import com.devsu.customerservice.domain.model.Gender;
import com.devsu.customerservice.domain.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static  com.devsu.customerservice.domain.validator.ClientValidator.*;


public class ClientServiceImp implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public ClientResponseDTO createClient(ClientCreateDTO clientCreateDTO) {
        Client client = ClientMapper.toEntity(clientCreateDTO);
        validateDataForCreate(client);
        client.generateClientId();
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
    public ClientResponseDTO getClientById(Long clientId) {
        Client client = getClientEntityById(clientId);
        return ClientMapper.toDTO(client);
    }

    @Override
    public ClientResponseDTO getByClientId(String clientId){
        Client client = getClientEntityByClientId(clientId);
        return ClientMapper.toDTO(client);
    }



    @Override
    public ClientResponseDTO updateClient(Long clientId, ClientUpdateDTO clientUpdateDTO) {
        Client client = getClientEntityById(clientId);
        ClientMapper.updateFromDTO(clientUpdateDTO, client);
        validateDataRequired(client);
        client = clientRepository.save(client);
        return ClientMapper.toDTO(client);
    }

    @Override
    public ClientResponseDTO patchClient(Long clientId, ClientUpdateDTO clientUpdateDTO) {
        Client client = getClientEntityById(clientId);

        if (clientUpdateDTO.getName() != null) {
            validateName(clientUpdateDTO.getName());
            client.setName(clientUpdateDTO.getName());
        }
        if (clientUpdateDTO.getGender() != null) {
            client.addGender(clientUpdateDTO.getGender());
        }
        if (clientUpdateDTO.getAge() > 0) {
            client.setAge(clientUpdateDTO.getAge());
        }
        if (clientUpdateDTO.getIdentification() != null) {
            client.setIdentification(clientUpdateDTO.getIdentification());
        }
        if (clientUpdateDTO.getAddress() != null) {
            validateAddress(clientUpdateDTO.getAddress());
            client.setAddress(clientUpdateDTO.getAddress());
        }
        if (clientUpdateDTO.getPhone() != null) {
            validatePhone(clientUpdateDTO.getPhone());
            client.setPhone(clientUpdateDTO.getPhone());
        }
        if (clientUpdateDTO.getStatus() != null) {
            client.setStatus(clientUpdateDTO.getStatus());
        }

        client = clientRepository.save(client);
        return ClientMapper.toDTO(client);
    }

    @Override
    public void deleteByClientId(String clientId) {
        clientRepository.deleteByClientId(clientId);
    }

    private Client getClientEntityById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new DomainException("Cliente no encontrado con id: " + id));
    }

    private Client getClientEntityByClientId(String clientId) {
        return clientRepository.findByClientId(clientId)
                .orElseThrow(() -> new DomainException("Client no encontrado con clientId: " + clientId));
    }
}
