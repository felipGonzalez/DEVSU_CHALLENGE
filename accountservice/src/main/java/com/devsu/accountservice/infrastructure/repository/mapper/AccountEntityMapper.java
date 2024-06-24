package com.devsu.accountservice.infrastructure.repository.mapper;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.infrastructure.repository.account.AccountEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountEntityMapper {

    public static Account mapToAccount(AccountEntity accountEntity){
        log.info(accountEntity.toString());
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setStatus(accountEntity.isStatus());
        account.setType(accountEntity.getType());
        account.setAccountId(accountEntity.getAccountId());
        account.setClientId(accountEntity.getClientId());
        account.setBalance(accountEntity.getBalance());
        return account;
    }

    public static AccountEntity mapToAccountEntity(Account account){
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
