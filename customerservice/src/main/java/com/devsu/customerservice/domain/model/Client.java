package com.devsu.customerservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    private Long id;
    private ClientId clientId;
    private String name;
    private Gender gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
    private String password;
    private boolean status;

    public void generateClientId(){
        clientId = ClientId.generate();
    }

    public void addClientId(String clientId){
        this.clientId = new ClientId(clientId);
    }

    public String getClientId(){
        return clientId != null ? clientId.getValue() : null;
    }

    public void addGender(String gender){
        this.gender = Gender.fromValue(gender);
    }

}
