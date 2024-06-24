package com.devsu.accountservice.application;

import com.devsu.accountservice.application.dto.AccountCreateDTO;
import com.devsu.accountservice.application.dto.AccountResponseDTO;
import com.devsu.accountservice.application.dto.AccountUpdateDTO;
import com.devsu.accountservice.application.mapper.AccountMapper;
import com.devsu.accountservice.domain.DomainException;
import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.repository.AccountRepository;
import com.devsu.accountservice.domain.repository.ClientRepository;
import com.devsu.accountservice.domain.repository.MovementRepository;

import static com.devsu.accountservice.domain.validator.AccountValidator.*;

import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImp implements AccountService{

    private final AccountRepository accountRepository;
    private final MovementRepository movementRepository;

    private final ClientRepository clientRepository;


    public AccountServiceImp(AccountRepository accountRepository,
                             MovementRepository movementRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponseDTO getAccountById(Long id) {
        Account account = getAccountEntityById(id);
        return AccountMapper.toDTO(account);
    }

    @Override
    public AccountResponseDTO getAccountByAccountId(String accountId) {
        Account account = getAccountEntityByAccountId(accountId);
        return AccountMapper.toDTO(account);
    }

    @Override
    public List<AccountResponseDTO> getAccountsByClientId(String clientId) {
        List<Account> accounts = accountRepository.findByClientId(clientId);
        return accounts.stream()
                .map(AccountMapper::toDTO).toList();
    }

    @Override
    public AccountResponseDTO createAccount(AccountCreateDTO accountCreateDTO) {
        Account account = AccountMapper.toEntity(accountCreateDTO);
        checkAccountId(account.getAccountId());
        validateDataCreateAccount(account);
        clientRepository.findByClientId(accountCreateDTO.getClientId())
                .orElseThrow(() -> new DomainException("No existe un cliente con id: " + accountCreateDTO.getClientId()));
        account = accountRepository.save(account);
        return AccountMapper.toDTO(account);
    }

    @Override
    public AccountResponseDTO updateAccount(String accountId, AccountUpdateDTO accountUpdateDTO) {
        Account account = getAccountEntityByAccountId(accountId);
        AccountMapper.updateFromDTO(accountUpdateDTO, account);
        validateDataRequiredAccount(account);
        account = accountRepository.save(account);
        return AccountMapper.toDTO(account);
    }

    @Override
    public void deleteByAccountId(String accountId) {
        movementRepository.deleteByAccountId(accountId);
        accountRepository.deleteByAccountId(accountId);
    }

    @Override
    public void deleteByClientId(String clientId) {
        List<Account> accounts = accountRepository.findByClientId(clientId);
        for (Account account: accounts ) {
            deleteByAccountId(account.getAccountId());
        }
    }

    private Account getAccountEntityById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new DomainException("Cuenta no encontrada con id: " + id));
    }

    private Account getAccountEntityByAccountId(String accountId) {
        return accountRepository.findByAccountId(accountId)
                .orElseThrow(() -> new DomainException("Cuenta no encontrada con el numero: " + accountId));
    }

    private void checkAccountId(String accountId){
        accountRepository.findByAccountId(accountId).ifPresent(account -> {
            throw new DomainException("Ya existe una cuenta registrada con el numero: " +accountId);
        });
    }
}
