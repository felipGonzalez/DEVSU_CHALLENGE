package com.devsu.customerservice.infrastructure.repository.client;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_person")
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;

}
