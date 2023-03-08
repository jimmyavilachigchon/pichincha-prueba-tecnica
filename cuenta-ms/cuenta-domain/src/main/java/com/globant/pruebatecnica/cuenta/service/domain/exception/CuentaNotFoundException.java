package com.globant.pruebatecnica.cuenta.service.domain.exception;

import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;

public class CuentaNotFoundException extends DomainException {

    public CuentaNotFoundException(String message) {
        super(message);
    }

    public CuentaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
