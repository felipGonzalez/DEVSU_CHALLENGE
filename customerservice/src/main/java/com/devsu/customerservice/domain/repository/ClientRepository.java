package com.devsu.customerservice.domain.repository;

import com.devsu.customerservice.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> findAll();

    Optional<Client> findById(Long clientId);

    Optional<Client> findByClientId(String clientId);

    public Client save(Client client);

    public void delete(Long clientId);
}
