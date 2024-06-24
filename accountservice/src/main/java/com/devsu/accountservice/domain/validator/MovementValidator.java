package com.devsu.accountservice.domain.validator;


import com.devsu.accountservice.domain.DomainException;
import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.AccountType;
import com.devsu.accountservice.domain.model.Movement;
import com.devsu.accountservice.domain.model.MovementType;

import java.math.BigDecimal;

public class MovementValidator {

    public static void validateDataCreateMovement(Movement movement) {
        validateAccountId(movement.getAccountId());
        validateAmount(movement.getAmount());
    }

    public static void validateDataMovement(Movement movement) {
        validateBalance(movement.getBalance());
        validateDataCreateMovement(movement);
        validateMovementType(movement.getMovementType());
    }


    public static void validateAccountId(String accountId) {
        if (accountId == null || accountId.isEmpty()) {
            throw new DomainException("El ID de la cuenta no puede ser nulo o vacío");
        }
    }

    public static void validateAmount(BigDecimal amount) {
        if (amount == null) {
            throw new DomainException("El monto del movimiento no puede ser null");
        }
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new DomainException("El monto del movimiento debe ser distinto de cero");
        }
    }

    public static void validateMovementType(MovementType type) {
        if (type == null) {
            throw new DomainException("El tipo de movimiento no puede ser nulo");
        }
    }

    public static void validateBalance(BigDecimal balance) {
        if (balance == null) {
            throw new DomainException("El monto del movimiento no puede ser null");
        }
    }

}
