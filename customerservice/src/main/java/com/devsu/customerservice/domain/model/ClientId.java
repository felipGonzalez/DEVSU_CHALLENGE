package com.devsu.customerservice.domain.model;

import com.devsu.customerservice.domain.DomainException;
import lombok.Value;

import java.util.UUID;

@Value
public class ClientId {
    String value;

    public ClientId(String value) {
        if (value == null || !value.matches("[a-zA-Z0-9]{5}")) {
            throw new DomainException("ClientId must be a 5-digit number :" + value);
        }
        this.value = value;
    }

    public static ClientId generate() {
        String uuid = UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        String clientId = uuid.substring(0, 6);
        return new ClientId(clientId);
    }
}