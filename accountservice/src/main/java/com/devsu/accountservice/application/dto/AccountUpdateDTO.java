package com.devsu.accountservice.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountUpdateDTO {

    private String type;
    private BigDecimal balance;
    private Boolean status;
}
