package com.globant.pruebatecnica.cliente.service.domain.exception;

import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;

public class ClienteDomainException extends DomainException {

    public ClienteDomainException(String message) {
        super(message);
    }

    public ClienteDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
