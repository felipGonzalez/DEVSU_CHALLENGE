package com.devsu.accountservice.infrastructure.repository.movement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataMovementEntityRepository extends JpaRepository<MovementEntity,Long> {

    List<MovementEntity> findByAccount_AccountId(String accountId);

    void deleteByAccount_AccountId(String accountId);

    List<MovementEntity> findByAccountClientIdAndDateAfter(String clientId,LocalDateTime date);
}
