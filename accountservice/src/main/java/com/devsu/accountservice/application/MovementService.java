package com.devsu.accountservice.application;

import com.devsu.accountservice.application.dto.MovementCreateDTO;
import com.devsu.accountservice.application.dto.MovementResponseDTO;

import java.util.List;

public interface MovementService {

    public List<MovementResponseDTO> getMovementsByAccountId(String accountId);

    public MovementResponseDTO getMovementById(Long id);

    public List<MovementResponseDTO> getAllMovements();

    public MovementResponseDTO createMovement(MovementCreateDTO movementDTO);

    void deleteByAccountId(String accountId);

    void deleteById(Long id);
}
