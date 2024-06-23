package com.devsu.customerservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClientResponseDTO {

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