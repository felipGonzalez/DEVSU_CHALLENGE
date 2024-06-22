package com.devsu.customerservice.domain.validator;

import com.devsu.customerservice.domain.DomainException;
import com.devsu.customerservice.domain.model.Client;

public class ClientValidator {

    public static void validateDataForCreate(Client client){
        validateDataRequired(client);
        validatePassword(client.getPassword());
    }

    public static void validateDataRequired(Client client){
        validateName(client.getName());
        validateAddress(client.getAddress());
        validatePhone(client.getPhone());
    }

    public static void validateName(String name) {
        if (isValidString(name)) {
            throw new DomainException("El nombre es obligatorio");
        }
    }

    public static void validateAddress(String address) {
        if (isValidString(address)) {
            throw new DomainException("La dirección es obligatoria");
        }
    }

    public static void validatePhone(String phone) {
        if (isValidString(phone) || isValidPhoneNumber(phone)) {
            throw new DomainException("El teléfono es obligatorio y solo puede contener números");
        }
    }

    public static void validatePassword(String password) {
        if (isValidString(password)) {
            throw new DomainException("La contraseña no puede ser nula o estar vacía");
        }

        if (password.length() < 4) {
            throw new DomainException("La contraseña debe tener minimo 4 caracteres");
        }
    }

    private static boolean isValidString(String str) {
        return str == null || str.trim().isEmpty();
    }

    private static boolean isValidPhoneNumber(String phone) {
        return phone != null && !phone.matches("^\\d+$");
    }

}
