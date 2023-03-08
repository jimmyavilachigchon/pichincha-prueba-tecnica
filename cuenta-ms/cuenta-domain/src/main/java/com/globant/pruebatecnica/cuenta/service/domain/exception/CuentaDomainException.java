package com.globant.pruebatecnica.cuenta.service.domain.exception;

import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;

public class CuentaDomainException extends DomainException {

    public CuentaDomainException(String message) {
        super(message);
    }

    public CuentaDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
