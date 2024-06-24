package com.devsu.accountservice.domain.repository;

import com.devsu.accountservice.domain.model.Client;

import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findByClientId(String clientId);

}
