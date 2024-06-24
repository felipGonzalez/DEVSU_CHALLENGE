package com.devsu.accountservice.infrastructure.repository.mapper;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.Movement;
import com.devsu.accountservice.infrastructure.repository.account.AccountEntity;
import com.devsu.accountservice.infrastructure.repository.movement.MovementEntity;

public class MovementEntityMapper {

    public static Movement mapToMovement(MovementEntity entity) {
        Account account = AccountEntityMapper.mapToAccount(entity.getAccount());
        Movement movement = new Movement();
        movement.setId(entity.getId());
        movement.setAccountId(entity.getAccount().getAccountId());
        movement.setDate(entity.getDate());
        movement.setAmount(entity.getAmount());
        movement.setMovementType(entity.getType());
        movement.setBalance(entity.getBalance());
        movement.setAccount(account);
        return movement;
    }

    public static MovementEntity mapToMovementEntity(Movement movement) {
        AccountEntity accountEntity = AccountEntityMapper.mapToAccountEntity(movement.getAccount());

        MovementEntity entity = new MovementEntity();
        entity.setId(movement.getId());
        entity.setAccount(accountEntity);
        entity.setDate(movement.getDate());
        entity.setAmount(movement.getAmount());
        entity.setType(movement.getMovementType());
        entity.setBalance(movement.getBalance());
        return entity;
    }

}
