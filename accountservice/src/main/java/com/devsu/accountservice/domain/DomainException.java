package com.devsu.accountservice.domain;

import org.springframework.http.HttpStatus;

public class DomainException extends RuntimeException{

    public DomainException(final String message) {
        super(message);

    }
}
