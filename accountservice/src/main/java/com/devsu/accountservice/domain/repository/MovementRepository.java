package com.devsu.accountservice.domain.repository;

import com.devsu.accountservice.domain.model.Movement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface MovementRepository {

    List<Movement> findMovementsByAccountId(String accountId);

    List<Movement> findAll();

    Movement save(Movement movement);

    Optional<Movement> findById(Long id);

    public void deleteByAccountId(String accountId);

    public void deleteById(Long id);


    List<Movement> findByClientIdAndDateAfter(String accountId, LocalDateTime date);


}
