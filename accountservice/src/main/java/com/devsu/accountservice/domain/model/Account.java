package com.devsu.accountservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;

    private String accountId;

    private AccountType type;

    private Double balance;

    private boolean status;

    private String clientId;

    private String clientName;

    public void addType(String type){
        this.type = AccountType.fromValue(type);
    }

}
