package com.globant.pruebatecnica.cuenta.service.domain.exception;

import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;

public class MovimientoNotFoundException extends DomainException {

    public MovimientoNotFoundException(String message) {
        super(message);
    }

    public MovimientoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
