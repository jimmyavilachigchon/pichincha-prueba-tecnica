package com.globant.pruebatecnica.cliente.service.dataaccess.mapper;

import com.globant.pruebatecnica.dataaccess.cliente.entity.ClienteEntity;
import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    public Cliente toCliente(ClienteEntity clienteEntity) {
        if (clienteEntity == null) {
            return null;
        }
        return new Cliente.Builder()
                .id(clienteEntity.getId())
                .nombre(clienteEntity.getNombre())
                .genero(clienteEntity.getGenero())
                .edad(clienteEntity.getEdad())
                .identificacion(clienteEntity.getIdentificacion())
                .direccion(clienteEntity.getDireccion())
                .telefono(clienteEntity.getTelefono())
                .estado(clienteEntity.getEstado())
                .build();
    }

    public ClienteEntity toClienteEntity(Cliente cliente) {
        return new ClienteEntity.Builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .genero(cliente.getGenero())
                .edad(cliente.getEdad())
                .identificacion(cliente.getIdentificacion())
                .direccion(cliente.getDireccion())
                .telefono(cliente.getTelefono())
                .password(cliente.getPassword())
                .estado(cliente.getEstado())
                .build();
    }

    public Iterable<Cliente> toClientes(Iterable<ClienteEntity> clientes) {
        return ((Collection<ClienteEntity>)clientes).stream()
                .map(clienteEntity -> new Cliente.Builder()
                        .id(clienteEntity.getId())
                        .nombre(clienteEntity.getNombre())
                        .genero(clienteEntity.getGenero())
                        .edad(clienteEntity.getEdad())
                        .identificacion(clienteEntity.getIdentificacion())
                        .direccion(clienteEntity.getDireccion())
                        .telefono(clienteEntity.getTelefono())
                        .estado(clienteEntity.getEstado())
                        .build())
                .collect(Collectors.toList());
    }
}