package com.devsu.accountservice.infrastructure.rest;

import com.devsu.accountservice.application.MovementService;
import com.devsu.accountservice.application.dto.MovementCreateDTO;
import com.devsu.accountservice.application.dto.MovementResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin("*")
public class MovementController {

    private final MovementService movementService;

    @Autowired
    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping()
    public ResponseEntity<List<MovementResponseDTO>> getAllMovement() {
        List<MovementResponseDTO> movements = movementService.getAllMovements();
        return ResponseEntity.ok(movements);
    }

    @GetMapping("/cuenta")
    public ResponseEntity<List<MovementResponseDTO>> getMovementsByAccountId(@RequestParam String id) {
        List<MovementResponseDTO> movements = movementService.getMovementsByAccountId(id);
        return ResponseEntity.ok(movements);
    }

    @PostMapping
    public ResponseEntity<MovementResponseDTO> createMovement(@RequestBody MovementCreateDTO movementDTO) {
        MovementResponseDTO createdMovement = movementService.createMovement(movementDTO);
        return ResponseEntity.ok(createdMovement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementResponseDTO> getMovementById(@PathVariable Long id) {
        return ResponseEntity.ok(movementService.getMovementById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Long id) {
        movementService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cuenta/{accountId}")
    public ResponseEntity<Void> deleteMovement(@PathVariable String accountId) {
        movementService.deleteByAccountId(accountId);
        return ResponseEntity.noContent().build();
    }
}
