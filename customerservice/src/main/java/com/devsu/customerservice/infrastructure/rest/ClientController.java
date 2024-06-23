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
@RequestMapping("/clientes")
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
       return ResponseEntity.ok(clientService.getByClientId(clientId));
    }


    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
      return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientCreateDTO clientCreateDTO) {
       return new ResponseEntity<>(clientService.createClient(clientCreateDTO),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @RequestBody ClientUpdateDTO clientUpdateDTO) {
        return ResponseEntity.ok(clientService.updateClient(id, clientUpdateDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> patchClient(@PathVariable Long id, @RequestBody ClientUpdateDTO clientUpdateDTO) {
        return ResponseEntity.ok(clientService.patchClient(id, clientUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        clientService.deleteByClientId(id);
        return ResponseEntity.noContent().build();
    }
}
