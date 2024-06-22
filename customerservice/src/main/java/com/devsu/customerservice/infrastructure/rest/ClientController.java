package com.devsu.customerservice.infrastructure.rest;

import com.devsu.customerservice.application.ClientService;
import com.devsu.customerservice.application.dto.ClientCreateDTO;
import com.devsu.customerservice.application.dto.ClientResponseDTO;
import com.devsu.customerservice.application.dto.ClientUpdateDTO;
import com.devsu.customerservice.domain.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(value = "*")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClient(@PathVariable Long id) {
        ClientResponseDTO client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/")
    public ResponseEntity<ClientResponseDTO> getClientByClientId(@RequestParam String clientId) {
        ClientResponseDTO client = clientService.getByClientId(clientId);
        return ResponseEntity.ok(client);
    }


    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientCreateDTO clientCreateDTO) {
        ClientResponseDTO createdClient = clientService.createClient(clientCreateDTO);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @RequestBody ClientUpdateDTO clientUpdateDTO) {
        ClientResponseDTO updatedClient = clientService.updateClient(id, clientUpdateDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> patchClient(@PathVariable Long id, @RequestBody ClientUpdateDTO clientUpdateDTO) {
        ClientResponseDTO patchedClient = clientService.patchClient(id, clientUpdateDTO);
        return ResponseEntity.ok(patchedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
