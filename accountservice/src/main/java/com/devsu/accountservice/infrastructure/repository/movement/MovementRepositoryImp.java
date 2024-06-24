package com.devsu.accountservice.infrastructure.repository.movement;

import com.devsu.accountservice.domain.model.Movement;
import com.devsu.accountservice.domain.repository.MovementRepository;
import com.devsu.accountservice.infrastructure.repository.mapper.MovementEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
public class MovementRepositoryImp implements MovementRepository {

    private final SpringDataMovementEntityRepository movementEntityRepository;

    @Autowired
    public MovementRepositoryImp(SpringDataMovementEntityRepository movementEntityRepository) {
        this.movementEntityRepository = movementEntityRepository;
    }

    @Override
    public List<Movement> findMovementsByAccountId(String accountId) {
        return movementEntityRepository
                .findByAccount_AccountId(accountId)
                .stream()
                .map(MovementEntityMapper::mapToMovement)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movement> findAll() {
        return movementEntityRepository
                .findAll()
                .stream()
                .map(MovementEntityMapper::mapToMovement)
                .collect(Collectors.toList());

    }

    @Override
    public Movement save(Movement movement) {
        MovementEntity movementEntity = MovementEntityMapper.mapToMovementEntity(movement);
        movementEntity = movementEntityRepository.save(movementEntity);
        return MovementEntityMapper.mapToMovement(movementEntity);
    }

    @Override
    public Optional<Movement> findById(Long id) {
        return movementEntityRepository
                .findById(id)
                .map(MovementEntityMapper::mapToMovement);
    }

    @Override
    public void deleteByAccountId(String accountId) {
        movementEntityRepository.deleteByAccount_AccountId(accountId);
    }

    @Override
    public void deleteById(Long id){
        movementEntityRepository.deleteById(id);
    }


    @Override
    public List<Movement> findByClientIdAndDateAfter(String accountId, LocalDateTime date){
        return movementEntityRepository
                .findByAccountClientIdAndDateAfter(accountId,date)
                .stream()
                .map(MovementEntityMapper::mapToMovement)
                .collect(Collectors.toList());
    }
}
