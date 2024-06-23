package com.devsu.accountservice.application;

import com.devsu.accountservice.application.dto.AccountCreateDTO;
import com.devsu.accountservice.application.dto.AccountResponseDTO;
import com.devsu.accountservice.application.dto.AccountUpdateDTO;

import java.util.List;

public interface AccountService {

    List<AccountResponseDTO> getAllAccounts();

    AccountResponseDTO getAccountById(Long id);

    AccountResponseDTO getAccountByAccountId(String accountId);

    List<AccountResponseDTO> getAccountsByClientId(String clientId);

    AccountResponseDTO createAccount(AccountCreateDTO accountCreateDTO);

    AccountResponseDTO updateAccount(String accountId, AccountUpdateDTO accountUpdateDTO);

    void deleteByAccountId(String accountId);

}
