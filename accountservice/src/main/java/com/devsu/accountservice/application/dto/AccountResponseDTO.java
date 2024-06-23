package com.devsu.accountservice.application.dto;

import lombok.Data;

@Data
public class AccountResponseDTO {
    private String accountId;
    private String type;
    private Double balance;
    private boolean status;
    private String clientId;
}
