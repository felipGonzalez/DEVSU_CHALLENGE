package com.devsu.customerservice.infrastructure.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataClientRepository extends JpaRepository<ClientEntity,Long>, JpaSpecificationExecutor<PersonEntity> {

    Optional<ClientEntity> findByClientId(String clientId);

    void deleteByClientId(String clientId);

}
