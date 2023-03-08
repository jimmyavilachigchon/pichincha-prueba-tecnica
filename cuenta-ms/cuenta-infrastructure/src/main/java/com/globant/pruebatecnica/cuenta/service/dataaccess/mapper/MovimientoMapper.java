package com.globant.pruebatecnica.cuenta.service.dataaccess.mapper;

import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import com.globant.pruebatecnica.cuenta.service.dataaccess.entity.CuentaEntity;
import com.globant.pruebatecnica.cuenta.service.dataaccess.entity.MovimientoEntity;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class MovimientoMapper {

  public Movimiento toMovimiento(MovimientoEntity movimientoEntity) {
    if (movimientoEntity == null) {
      return null;
    }
    return new Movimiento.Builder()
        .tipoMovimiento(movimientoEntity.getTipoMovimiento())
        .id(movimientoEntity.getId())
        .fecha(movimientoEntity.getFecha())
        .saldo(movimientoEntity.getSaldo())
        .valor(movimientoEntity.getValor())
        .cuenta(new Cuenta.Builder()
            .id(movimientoEntity.getCuentaEntity().getId())
            .numeroCuenta(movimientoEntity.getCuentaEntity().getNumeroCuenta())
            .tipoCuenta(movimientoEntity.getCuentaEntity().getTipoCuenta())
            .saldoInicial(movimientoEntity.getCuentaEntity().getSaldoInicial())
            .estado((movimientoEntity.getCuentaEntity().getEstado()))
            .build())
        .build();
  }

  public MovimientoEntity toMovimientoEntity(Movimiento movimiento) {
    return new MovimientoEntity.Builder()
        .tipoMovimiento(movimiento.getTipoMovimiento())
        .fecha(movimiento.getFecha())
        .saldo(movimiento.getSaldo())
        .valor(movimiento.getValor())
        .cuentaEntity(new CuentaEntity.Builder()
            .id(movimiento.getCuenta().getId())
            .build())
        .build();
  }

  public Iterable<Movimiento> toMovimientos(Iterable<MovimientoEntity> movimientos) {
    return ((Collection<MovimientoEntity>) movimientos).stream()
        .map(movimientoEntity -> new Movimiento.Builder()
            .tipoMovimiento(movimientoEntity.getTipoMovimiento())
            .id(movimientoEntity.getId())
            .fecha(movimientoEntity.getFecha())
            .saldo(movimientoEntity.getSaldo())
            .valor(movimientoEntity.getValor())
            .cuenta(new Cuenta.Builder()
                .id(movimientoEntity.getCuentaEntity().getId())
                .numeroCuenta(movimientoEntity.getCuentaEntity().getNumeroCuenta())
                .tipoCuenta(movimientoEntity.getCuentaEntity().getTipoCuenta())
                .saldoInicial(movimientoEntity.getCuentaEntity().getSaldoInicial())
                .estado((movimientoEntity.getCuentaEntity().getEstado()))
                .cliente(new Cliente.Builder()
                    .id(movimientoEntity.getCuentaEntity().getClienteEntity().getId())
                    .identificacion(movimientoEntity.getCuentaEntity().getClienteEntity().getIdentificacion())
                    .nombre(movimientoEntity.getCuentaEntity().getClienteEntity().getNombre())
                    .build())
                .build())
            .build())
        .collect(Collectors.toList());
  }

}
