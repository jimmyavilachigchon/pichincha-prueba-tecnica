package com.globant.pruebatecnica.cliente.service.domain.ports.input;

import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Iterable<Cliente> getClientes();

    Optional<Cliente> getClienteById(Integer id);

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente);

    void deleteById(Integer id);

}