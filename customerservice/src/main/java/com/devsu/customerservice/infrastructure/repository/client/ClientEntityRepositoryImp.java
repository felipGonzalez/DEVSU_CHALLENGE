package com.devsu.customerservice.infrastructure.repository.client;

import com.devsu.customerservice.domain.model.Client;
import com.devsu.customerservice.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientEntityRepositoryImp implements ClientRepository {

    private final SpringDataPersonRepository springDataPersonRepository;

    private final SpringDataClientRepository springDataClientRepository;

    @Autowired
    public ClientEntityRepositoryImp(SpringDataPersonRepository springDataPersonRepository, SpringDataClientRepository springDataClientRepository) {
        this.springDataPersonRepository = springDataPersonRepository;
        this.springDataClientRepository = springDataClientRepository;
    }

    @Override
    public List<Client> findAll() {
        return springDataClientRepository.findAll().stream()
                .map(this::mapToClient)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(Long clientId) {
        return springDataClientRepository.findById(clientId)
                .map(this::mapToClient);
    }

    @Override
    public Optional<Client> findByClientId(String clientId) {
        return springDataClientRepository.findByClientId(clientId)
                .map(this::mapToClient);
    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = mapToClientEntity(client);
        clientEntity = springDataClientRepository.save(clientEntity);
        return mapToClient(clientEntity);
    }

    @Override
    public void delete(Long clientId) {
        springDataClientRepository.deleteById(clientId);
    }

    private Client mapToClient(ClientEntity clientEntity) {
        Client client = new Client();
        client.setId(clientEntity.getId());
        client.addClientId(clientEntity.getClientId());
        client.setName(clientEntity.getName());
        client.setGender(clientEntity.getGender());
        client.setAge(clientEntity.getAge());
        client.setIdentification(clientEntity.getIdentification());
        client.setAddress(clientEntity.getAddress());
        client.setPhone(clientEntity.getPhone());
        client.setPassword(clientEntity.getPassword());
        client.setStatus(clientEntity.isStatus());
        return client;
    }

    private ClientEntity mapToClientEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setClientId(client.getClientId().getValue());
        clientEntity.setName(client.getName());
        clientEntity.setGender(client.getGender());
        clientEntity.setAge(client.getAge());
        clientEntity.setIdentification(client.getIdentification());
        clientEntity.setAddress(client.getAddress());
        clientEntity.setPhone(client.getPhone());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setStatus(client.isStatus());
        return clientEntity;
    }
}
