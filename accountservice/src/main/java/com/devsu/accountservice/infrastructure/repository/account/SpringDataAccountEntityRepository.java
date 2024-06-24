package com.devsu.accountservice.infrastructure.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataAccountEntityRepository extends JpaRepository<AccountEntity,Long> {

    Optional<AccountEntity> findByAccountId(String accountId);
    List<AccountEntity> findByClientId(String clientId);
    void deleteByAccountId(String accountId);

}
