package com.devsu.accountservice.application.dto;

import lombok.Data;

@Data
public class AccountUpdateDTO {

    private String type;
    private Double balance;
    private Boolean status;
}
