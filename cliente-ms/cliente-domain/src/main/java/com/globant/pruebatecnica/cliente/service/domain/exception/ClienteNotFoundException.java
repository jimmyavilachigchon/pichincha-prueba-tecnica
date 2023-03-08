package com.globant.pruebatecnica.cliente.service.domain.exception;

import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;

public class ClienteNotFoundException extends DomainException {

    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
