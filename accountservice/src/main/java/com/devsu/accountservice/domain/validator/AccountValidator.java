package com.devsu.accountservice.domain.validator;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.AccountType;

import java.math.BigDecimal;

public class AccountValidator {

    public static void validateDataCreateAccount(Account account) {
        validateAccountId(account.getAccountId());
        validateClientId(account.getAccountId());
        validateDataRequiredAccount(account);
    }

    public static void validateDataRequiredAccount(Account account) {
        validateAccountType(account.getType());
        validateBalance(account.getBalance());
    }

    public static void validateAccountId(String accountId) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("El ID de la cuenta no puede ser nulo o vacío");
        }
    }

    public static void validateAccountType(AccountType accountType) {
        if (accountType == null) {
            throw new IllegalArgumentException("El tipo de cuenta no puede ser nulo");
        }
    }

    public static void validateClientId(String accountId) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("El ID del cliente no puede ser nulo o vacío");
        }
    }

    public static void validateBalance(Double balance) {
        if (balance == null ) {
            throw new IllegalArgumentException("El saldo inicial no puede ser nulo");
        }
    }

}
