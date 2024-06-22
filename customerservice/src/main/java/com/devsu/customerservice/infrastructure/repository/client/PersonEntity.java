package com.devsu.customerservice.infrastructure.repository.client;

import com.devsu.customerservice.domain.model.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    private int age;
    private String identification;
    private String address;
    private String phone;

}
