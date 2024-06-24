package com.devsu.accountservice.infrastructure.repository.account;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.repository.AccountRepository;
import com.devsu.accountservice.infrastructure.repository.mapper.AccountEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@Transactional
public class AccountRepositoryImp implements AccountRepository {

    private final SpringDataAccountEntityRepository accountEntityRepository;

    @Autowired
    public AccountRepositoryImp(SpringDataAccountEntityRepository accountEntityRepository) {
        this.accountEntityRepository = accountEntityRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountEntityRepository
                .findAll()
                .stream()
                .map(AccountEntityMapper::mapToAccount)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return accountEntityRepository
                .findById(accountId)
                .map(AccountEntityMapper::mapToAccount);
    }

    @Override
    public Optional<Account> findByAccountId(String accountId) {
        return accountEntityRepository
                .findByAccountId(accountId)
                .map(AccountEntityMapper::mapToAccount);
    }

    @Override
    public List<Account> findByClientId(String clientId){
        return accountEntityRepository.findByClientId(clientId)
                .stream()
                .map(AccountEntityMapper::mapToAccount).toList();
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = AccountEntityMapper.mapToAccountEntity(account);
        accountEntity = accountEntityRepository.save(accountEntity);
        return AccountEntityMapper.mapToAccount(accountEntity);
    }

    @Override
    public void deleteByAccountId(String accountId) {
        accountEntityRepository.deleteByAccountId(accountId);
    }

}
