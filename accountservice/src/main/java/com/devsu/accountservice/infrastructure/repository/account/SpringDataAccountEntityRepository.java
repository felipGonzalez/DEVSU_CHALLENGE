package com.devsu.accountservice.infrastructure.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataAccountEntityRepository extends JpaRepository<AccountEntity,Long> {

    Optional<AccountEntity> findByAccountId(String accountId);
    List<AccountEntity> findByClientId(String clientId);

    void deleteByAccountId(String accountId);
}
