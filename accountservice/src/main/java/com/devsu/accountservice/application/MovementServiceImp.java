package com.devsu.accountservice.application;

import com.devsu.accountservice.application.dto.MovementCreateDTO;
import com.devsu.accountservice.application.dto.MovementResponseDTO;
import com.devsu.accountservice.application.mapper.MovementMapper;
import com.devsu.accountservice.domain.DomainException;
import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.Movement;
import com.devsu.accountservice.domain.model.MovementType;
import com.devsu.accountservice.domain.repository.AccountRepository;
import com.devsu.accountservice.domain.repository.MovementRepository;
import com.devsu.accountservice.domain.validator.MovementValidator;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MovementServiceImp implements MovementService{

    private final MovementRepository movementRepository;

    private final AccountRepository accountRepository;

    public MovementServiceImp(MovementRepository movementRepository, AccountRepository accountRepository) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public MovementResponseDTO getMovementById(Long id) {
        Movement movement = getMovementEntityById(id);
        return MovementMapper.toDTO(movement);
    }

    @Override
    public List<MovementResponseDTO> getMovementsByAccountId(String accountId) {
        List<Movement> accounts = movementRepository.findMovementsByAccountId(accountId);
        return accounts.stream()
                .map(MovementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovementResponseDTO> getAllMovements() {
        List<Movement> accounts = movementRepository.findAll();
        return accounts.stream()
                .map(MovementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovementResponseDTO createMovement(MovementCreateDTO movementDTO) {
        Movement movement = MovementMapper.toEntity(movementDTO);
        movement.addMovement(getAccountEntityByAccountId(movementDTO.getAccountId()));
        MovementValidator.validateDataMovement(movement);
        accountRepository.save(movement.getAccount());
        return MovementMapper.toDTO(movementRepository.save(movement));
    }

    @Override
    public void deleteByAccountId(String accountId) {
        movementRepository.deleteByAccountId(accountId);
    }

    @Override
    public void deleteById(Long id){
        movementRepository.deleteById(id);
    }

    private Movement getMovementEntityById(Long id) {
        return movementRepository.findById(id)
                .orElseThrow(() -> new DomainException("Movimiento no encontrada con id: " + id));
    }

    private Account getAccountEntityByAccountId(String accountId) {
        return accountRepository.findByAccountId(accountId)
                .orElseThrow(() -> new DomainException("Cuenta no encontrada con el numero: " + accountId));
    }

}
