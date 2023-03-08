package com.globant.pruebatecnica.cliente.service.domain.ports.output;

import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepository {

    Iterable<Cliente> getClientes();

    Optional<Cliente> getClienteById(Integer id);

    Optional<Cliente> getClienteByIdentificacion(String identificacion);

    Cliente save(Cliente cliente);

    void delete(Integer id);

}
