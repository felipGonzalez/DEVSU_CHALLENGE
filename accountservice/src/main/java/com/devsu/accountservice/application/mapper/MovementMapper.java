package com.devsu.accountservice.application.mapper;

import com.devsu.accountservice.application.dto.MovementCreateDTO;
import com.devsu.accountservice.application.dto.MovementResponseDTO;
import com.devsu.accountservice.domain.model.Movement;
import com.devsu.accountservice.domain.model.MovementType;

public class MovementMapper {

    public static MovementResponseDTO toDTO(Movement movement) {
        if (movement == null) {
            return null;
        }
        MovementResponseDTO dto = new MovementResponseDTO();
        dto.setId(movement.getId());
        dto.setAccountId(movement.getAccountId());
        dto.addDate(movement.getDate());
        dto.setAmount(movement.getAmount());
        dto.setMovementType(movement.getMovementType().getValue());
        dto.setBalance(movement.getBalance());
        dto.setAccountType(movement.getTypeAccountValue());
        return dto;
    }

    public static Movement toEntity(MovementCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        Movement movement = new Movement();
        movement.setAccountId(dto.getAccountId());
        movement.setAmount(dto.getAmount());
        return movement;
    }
}
