package com.devsu.customerservice.infrastructure.repository.client;

import com.devsu.customerservice.domain.model.Client;
import com.devsu.customerservice.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
public class ClientRepositoryImp implements ClientRepository {

    private final SpringDataClientRepository springDataClientRepository;

    @Autowired
    public ClientRepositoryImp(SpringDataClientRepository springDataClientRepository) {
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
    public void deleteByClientId(String clientId) {
        springDataClientRepository.deleteByClientId(clientId);
    }

    private Client mapToClient(ClientEntity clientEntity) {
        Client client = new Client();
        client.setId(clientEntity.getId());
        client.setName(clientEntity.getName());
        client.setGender(clientEntity.getGender());
        client.setAge(clientEntity.getAge());
        client.setIdentification(clientEntity.getIdentification());
        client.setAddress(clientEntity.getAddress());
        client.setPhone(clientEntity.getPhone());
        client.setPassword(clientEntity.getPassword());
        client.setStatus(clientEntity.isStatus());
        client.addClientId(clientEntity.getClientId());
        return client;
    }

    private ClientEntity mapToClientEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setName(client.getName());
        clientEntity.setGender(client.getGender());
        clientEntity.setAge(client.getAge());
        clientEntity.setIdentification(client.getIdentification());
        clientEntity.setAddress(client.getAddress());
        clientEntity.setPhone(client.getPhone());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setStatus(client.isStatus());
        clientEntity.setClientId(client.getClientId());
        return clientEntity;
    }
}
