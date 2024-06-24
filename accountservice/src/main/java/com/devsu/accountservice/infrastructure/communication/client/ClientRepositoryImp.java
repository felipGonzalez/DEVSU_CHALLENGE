package com.devsu.accountservice.infrastructure.communication.client;

import com.devsu.accountservice.domain.model.Client;
import com.devsu.accountservice.domain.repository.ClientRepository;
import com.devsu.accountservice.infrastructure.communication.SyncRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ClientRepositoryImp implements ClientRepository {

    private final SyncRestService syncRestService;

    @Autowired
    public ClientRepositoryImp(SyncRestService syncRestService) {
        this.syncRestService = syncRestService;
    }

    @Override
    public Optional<Client> findByClientId(String clientId) {
        return Optional.ofNullable(syncRestService.getDataClient("clientes/?clientId="+clientId, Client.class));
    }
}
