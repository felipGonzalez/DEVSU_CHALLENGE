package com.devsu.customerservice.domain;

public class DomainException extends RuntimeException{

    public DomainException(final String message) {
        super(message);
    }
}
