package com.devsu.accountservice.domain.model;

import lombok.Data;

@Data
public class Client {

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