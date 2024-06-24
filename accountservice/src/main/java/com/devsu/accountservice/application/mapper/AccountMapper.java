package com.devsu.accountservice.application.mapper;

import com.devsu.accountservice.application.dto.AccountCreateDTO;
import com.devsu.accountservice.application.dto.AccountResponseDTO;
import com.devsu.accountservice.application.dto.AccountUpdateDTO;
import com.devsu.accountservice.domain.model.Account;

public class AccountMapper {

    public static Account toEntity(AccountCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        Account entity = new Account();
        entity.setAccountId(dto.getAccountId());
        entity.addType(dto.getType());
        entity.setBalance(dto.getBalance());
        entity.setStatus(dto.isStatus());
        entity.setClientId(dto.getClientId());
        return entity;
    }

    public static AccountResponseDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setAccountId(account.getAccountId());
        dto.setType(account.getTypeAccountValue());
        dto.setBalance(account.getBalance());
        dto.setStatus(account.isStatus());
        dto.setClientId(account.getClientId());
        return dto;
    }

    public static void updateFromDTO(AccountUpdateDTO dto, Account entity) {
        if (dto == null || entity == null) {
            return;
        }
        if (dto.getType() != null) {
            entity.addType(dto.getType());
        }
        if (dto.getBalance() != null) {
            entity.setBalance(dto.getBalance());
        }
        if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }
    }
}
