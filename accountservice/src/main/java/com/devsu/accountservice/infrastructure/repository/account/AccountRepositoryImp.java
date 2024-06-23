package com.devsu.accountservice.infrastructure.repository.account;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.repository.AccountRepository;
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
                .map(this::mapToAccount)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return accountEntityRepository
                .findById(accountId)
                .map(this::mapToAccount);
    }

    @Override
    public Optional<Account> findByAccountId(String accountId) {
        return accountEntityRepository
                .findByAccountId(accountId)
                .map(this::mapToAccount);
    }

    @Override
    public List<Account> findByClientId(String clientId){
        return accountEntityRepository.findByClientId(clientId)
                .stream()
                .map(this::mapToAccount).toList();
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = mapToAccountEntity(account);
        accountEntity = accountEntityRepository.save(accountEntity);
        return mapToAccount(accountEntity);
    }

    @Override
    public void deleteByAccountId(String accountId) {
        accountEntityRepository.deleteByAccountId(accountId);
    }

    private Account mapToAccount(AccountEntity accountEntity){
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setStatus(accountEntity.isStatus());
        account.setType(accountEntity.getType());
        account.setAccountId(accountEntity.getAccountId());
        account.setClientId(accountEntity.getClientId());
        account.setBalance(accountEntity.getBalance());
        return account;
    }

    private AccountEntity mapToAccountEntity(Account account){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(account.getId());
        accountEntity.setStatus(account.isStatus());
        accountEntity.setType(account.getType());
        accountEntity.setAccountId(account.getAccountId());
        accountEntity.setClientId(account.getClientId());
        accountEntity.setBalance(account.getBalance());
        return accountEntity;
    }
}
