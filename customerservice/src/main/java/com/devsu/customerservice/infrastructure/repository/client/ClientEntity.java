package com.devsu.customerservice.infrastructure.repository.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
public class ClientEntity extends PersonEntity {

    @Column(name = "clientId", unique = true, nullable = false)
    private String clientId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private boolean status;
}
