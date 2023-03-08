package com.globant.pruebatecnica.cuenta.service.domain.exception;

import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;

public class MovimientoDomainException extends DomainException {

    public MovimientoDomainException(String message) {
        super(message);
    }

    public MovimientoDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
