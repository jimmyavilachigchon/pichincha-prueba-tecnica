package com.globant.pruebatecnica.cliente.service.domain.ports.input;

import com.globant.pruebatecnica.cliente.service.domain.exception.ClienteDomainException;
import com.globant.pruebatecnica.cliente.service.domain.exception.ClienteNotFoundException;
import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import com.globant.pruebatecnica.cliente.service.domain.ports.input.ClienteService;
import com.globant.pruebatecnica.cliente.service.domain.ports.output.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Slf4j
@Validated
@Service
public class ClienteServiceImpl implements ClienteService {
  private ClienteRepository clienteRepository;

  public ClienteServiceImpl(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Override
  public Iterable<Cliente> getClientes() {
    return this.clienteRepository.getClientes();
  }

  @Override
  public Optional<Cliente> getClienteById(Integer id) {
    return this.clienteRepository.getClienteById(id);
  }

  @Override
  public Cliente save(Cliente cliente) {
    cliente.validateData();
    validateIfExistsCliente(cliente.getIdentificacion());
    return this.clienteRepository.save(cliente);
  }

  @Override
  public Cliente update(Cliente cliente) {
    cliente.validateData();
    validateIfExistsCliente(cliente.getIdentificacion());
    return this.clienteRepository.save(cliente);
  }

  @Override
  public void deleteById(Integer id) {
    validateIfExistsCliente(id);
    this.clienteRepository.delete(id);
  }

  private void validateIfExistsCliente(String identificacion) {
    this.clienteRepository.getClienteByIdentificacion(identificacion).ifPresent(res -> {
      throw new ClienteDomainException(
          "El cliente con identificacion " + res.getIdentificacion() + " ya existe.");
    });
  }

  private void validateIfExistsCliente(Integer id) {
    this.clienteRepository.getClienteById(id).orElseThrow(() ->
        new ClienteNotFoundException("No se encontró el cliente con el ID:" + id)
    );
  }

}