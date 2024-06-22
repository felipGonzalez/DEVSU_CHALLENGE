package com.devsu.customerservice.infrastructure.repository.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@DiscriminatorValue("CLIENTE")
@Getter
@Setter
public class ClientEntity extends PersonEntity {

    @Column(unique = true)
    private String clientId;

    private String password;

    private boolean status;
}
