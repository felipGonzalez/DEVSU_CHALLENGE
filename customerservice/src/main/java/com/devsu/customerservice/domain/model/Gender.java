package com.devsu.customerservice.domain.model;

import com.devsu.customerservice.domain.DomainException;

public enum Gender {
    MALE("Hombre"),
    FEMALE("Mujer"),
    OTHER("Otro");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Gender fromValue(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.value.equalsIgnoreCase(value)) {
                return gender;
            }
        }
        StringBuilder validValues = new StringBuilder();
        for (Gender gender : Gender.values()) {
            validValues.append(gender.value).append(", ");
        }
        validValues.setLength(validValues.length() - 2);
        throw new DomainException("Genero no valido: " + value + ". Los valores validos son: " + validValues);
    }
}