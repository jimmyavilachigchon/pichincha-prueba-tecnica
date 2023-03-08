package com.globant.pruebatecnica.cliente.service.application.handler;

import com.globant.pruebatecnica.cliente.service.domain.application.handler.ErrorDTO;
import com.globant.pruebatecnica.cliente.service.domain.application.handler.GlobalExceptionHandler;
import com.globant.pruebatecnica.cliente.service.domain.exception.ClienteDomainException;
import com.globant.pruebatecnica.cliente.service.domain.exception.ClienteNotFoundException;
import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ClienteGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {ClienteDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(ClienteDomainException clienteDomainException) {
        log.error(clienteDomainException.getMessage(), clienteDomainException);
        return ErrorDTO.builder()
            .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
            .message(clienteDomainException.getMessage())
            .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {DomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(DomainException domainException) {
        log.error(domainException.getMessage(), domainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(domainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ClienteNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(ClienteNotFoundException clienteNotFoundException) {
        log.error(clienteNotFoundException.getMessage(), clienteNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(clienteNotFoundException.getMessage())
                .build();
    }
}
