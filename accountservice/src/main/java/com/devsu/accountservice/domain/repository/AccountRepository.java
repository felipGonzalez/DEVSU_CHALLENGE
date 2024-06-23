package com.devsu.accountservice.domain.repository;

import com.devsu.accountservice.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    List<Account> findAll();

    Optional<Account> findById(Long accountId);

    Optional<Account> findByAccountId(String accountId);

    List<Account> findByClientId(String clientId);

    public Account save(Account account);

    public void deleteByAccountId(String accountId);

}
