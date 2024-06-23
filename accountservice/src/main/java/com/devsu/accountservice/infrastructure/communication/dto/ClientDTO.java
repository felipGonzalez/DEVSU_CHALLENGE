package com.devsu.accountservice.infrastructure.communication.dto;

import lombok.Data;

@Data
public class ClientDTO {

    private Long id;
    private String clientId;
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
    private boolean status;

}