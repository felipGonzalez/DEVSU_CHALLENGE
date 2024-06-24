package com.devsu.accountservice.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovementCreateDTO {

    private String accountId;
    private BigDecimal amount;

}
