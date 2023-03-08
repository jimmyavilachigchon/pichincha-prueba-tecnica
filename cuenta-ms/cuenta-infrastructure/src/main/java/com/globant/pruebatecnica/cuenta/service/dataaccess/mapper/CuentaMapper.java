package com.globant.pruebatecnica.cuenta.service.dataaccess.mapper;

import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import com.globant.pruebatecnica.cuenta.service.dataaccess.entity.CuentaEntity;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.dataaccess.cliente.entity.ClienteEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CuentaMapper {

  public Cuenta toCuenta(CuentaEntity cuentaEntity) {
    if (cuentaEntity == null) {
      return null;
    }
    return new Cuenta.Builder()
        .id(cuentaEntity.getId())
        .numeroCuenta(cuentaEntity.getNumeroCuenta())
        .tipoCuenta(cuentaEntity.getTipoCuenta())
        .saldoInicial(cuentaEntity.getSaldoInicial())
        .estado((cuentaEntity.getEstado()))
        .cliente(new Cliente.Builder()
            .id(cuentaEntity.getClienteEntity().getId())
            .identificacion(cuentaEntity.getClienteEntity().getIdentificacion())
            .edad(cuentaEntity.getClienteEntity().getEdad())
            .genero(cuentaEntity.getClienteEntity().getGenero())
            .direccion(cuentaEntity.getClienteEntity().getDireccion())
            .telefono(cuentaEntity.getClienteEntity().getTelefono())
            .nombre(cuentaEntity.getClienteEntity().getNombre())
            .build())
        .build();
  }

  public CuentaEntity toCuentaEntity(Cuenta cuenta) {
    return new CuentaEntity.Builder()
        .id(cuenta.getId())
        .numeroCuenta(cuenta.getNumeroCuenta())
        .tipoCuenta(cuenta.getTipoCuenta())
        .saldoInicial(cuenta.getSaldoInicial())
        .estado((cuenta.getEstado()))
        .clienteEntity(new ClienteEntity.Builder()
            .id(cuenta.getCliente().getId())
            .build())
        .build();
  }

  public Iterable<Cuenta> toCuentas(Iterable<CuentaEntity> cuentas) {
    return ((Collection<CuentaEntity>) cuentas).stream()
        .map(cuentaEntity -> new Cuenta.Builder()
            .id(cuentaEntity.getId())
            .numeroCuenta(cuentaEntity.getNumeroCuenta())
            .tipoCuenta(cuentaEntity.getTipoCuenta())
            .saldoInicial(cuentaEntity.getSaldoInicial())
            .estado((cuentaEntity.getEstado()))
            .cliente(new Cliente.Builder()
                .id(cuentaEntity.getClienteEntity().getId())
                .identificacion(cuentaEntity.getClienteEntity().getIdentificacion())
                .edad(cuentaEntity.getClienteEntity().getEdad())
                .genero(cuentaEntity.getClienteEntity().getGenero())
                .direccion(cuentaEntity.getClienteEntity().getDireccion())
                .telefono(cuentaEntity.getClienteEntity().getTelefono())
                .nombre(cuentaEntity.getClienteEntity().getNombre())
                .build())
            .build())
        .collect(Collectors.toList());
  }
}