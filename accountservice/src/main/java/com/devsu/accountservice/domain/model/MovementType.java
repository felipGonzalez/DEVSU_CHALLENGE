package com.devsu.accountservice.domain.model;

import com.devsu.accountservice.domain.DomainException;

import java.math.BigDecimal;

public enum MovementType {

    DEPOSIT("Deposito"),
    WITHDRAWAL("Retiro");

    private final String value;

    MovementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MovementType fromValue(String value) {
        for (MovementType movementType : MovementType.values()) {
            if (movementType.value.equalsIgnoreCase(value)) {
                return movementType;
            }
        }
        StringBuilder validValues = new StringBuilder();
        for (MovementType movementType : MovementType.values()) {
            validValues.append(movementType.value).append(", ");
        }
        validValues.setLength(validValues.length() - 2);
        throw new DomainException("Tipo de movimineto no valido: " + value + ". Los valores validos son: " + validValues);
    }

    public static MovementType getTypeFromAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            return MovementType.DEPOSIT;
        } else {
            return MovementType.WITHDRAWAL;
        }
    }

}
