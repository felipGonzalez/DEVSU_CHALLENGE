package com.devsu.accountservice.infrastructure.repository.account;

import com.devsu.accountservice.domain.model.AccountType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id", unique = true, nullable = false)
    private String accountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AccountType type;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "client_id", nullable = false)
    private String clientId;
}
