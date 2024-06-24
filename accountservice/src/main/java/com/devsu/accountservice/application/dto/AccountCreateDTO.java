package com.devsu.accountservice.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountCreateDTO {

    private String accountId;
    private String type;
    private BigDecimal balance;
    private boolean status;
    private String clientId;

}
