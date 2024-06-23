package com.devsu.accountservice.infrastructure.rest;

import com.devsu.accountservice.application.AccountService;
import com.devsu.accountservice.application.dto.AccountCreateDTO;
import com.devsu.accountservice.application.dto.AccountResponseDTO;
import com.devsu.accountservice.application.dto.AccountUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> getAccount(@PathVariable String accountId) {
        return ResponseEntity.ok(accountService.getAccountByAccountId(accountId));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<AccountResponseDTO>> getAccountsByClientId(@RequestParam String clientId) {
        return ResponseEntity.ok(accountService.getAccountsByClientId(clientId));
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountCreateDTO accountCreateDTO) {
        return ResponseEntity.ok(accountService.createAccount(accountCreateDTO));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable String accountId, @RequestBody AccountUpdateDTO accountUpdateDTO) {
        return ResponseEntity.ok(accountService.updateAccount(accountId, accountUpdateDTO));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountId) {
        accountService.deleteByAccountId(accountId);
        return ResponseEntity.noContent().build();
    }
}
