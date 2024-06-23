package com.devsu.accountservice.domain.model;

import com.devsu.accountservice.domain.DomainException;
import lombok.Getter;

public enum AccountType {
    SAVINGS("Ahorro"),
    CURRENT("Corriente");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AccountType fromValue(String value) {
        for (AccountType accountType : AccountType.values()) {
            if (accountType.value.equalsIgnoreCase(value)) {
                return accountType;
            }
        }
        StringBuilder validValues = new StringBuilder();
        for (AccountType accountType : AccountType.values()) {
            validValues.append(accountType.value).append(", ");
        }
        validValues.setLength(validValues.length() - 2);
        throw new DomainException("Tipo de cuenta no valida: " + value + ". Los valores validos son: " + validValues);
    }
}