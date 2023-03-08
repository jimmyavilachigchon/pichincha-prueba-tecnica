package com.globant.pruebatecnica.cliente.service.dataaccess.adapter;

import com.globant.pruebatecnica.cliente.service.dataaccess.mapper.ClienteMapper;
import com.globant.pruebatecnica.cliente.service.dataaccess.adapter.repository.ClienteJpaRepositoryHelper;
import com.globant.pruebatecnica.dataaccess.cliente.entity.ClienteEntity;
import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import com.globant.pruebatecnica.cliente.service.domain.ports.output.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class ClienteRepositoryImpl implements ClienteRepository {

  private final ClienteJpaRepositoryHelper clienteJpaRepositoryHelper;

  private final ClienteMapper clienteMapper;

  public ClienteRepositoryImpl(ClienteJpaRepositoryHelper clienteJpaRepositoryHelper, ClienteMapper clienteMapper) {
    this.clienteJpaRepositoryHelper = clienteJpaRepositoryHelper;
    this.clienteMapper = clienteMapper;
  }

  @Override
  public Iterable<Cliente> getClientes() {
    return clienteMapper.toClientes(clienteJpaRepositoryHelper.findAll());
  }

  @Override
  public Optional<Cliente> getClienteById(Integer id) {
    ClienteEntity cliente = this.clienteJpaRepositoryHelper.findById(id).orElse(null);
    return Optional.ofNullable(this.clienteMapper.toCliente(cliente));
  }

  @Override
  public Optional<Cliente> getClienteByIdentificacion(String identificacion) {
    ClienteEntity clienteEntity = this.clienteJpaRepositoryHelper.findByIdentificacion(identificacion).orElse(null);
    return Optional.ofNullable(this.clienteMapper.toCliente(clienteEntity));
  }

  @Override
  public Cliente save(Cliente cliente) {
    ClienteEntity clienteEntity = this.clienteMapper.toClienteEntity(cliente);
    System.out.println("Nombre: " + clienteEntity.getNombre());
    return this.clienteMapper.toCliente(this.clienteJpaRepositoryHelper.save(clienteEntity));
  }

  @Override
  public void delete(Integer id) {
    this.clienteJpaRepositoryHelper.deleteById(id);
  }
}
