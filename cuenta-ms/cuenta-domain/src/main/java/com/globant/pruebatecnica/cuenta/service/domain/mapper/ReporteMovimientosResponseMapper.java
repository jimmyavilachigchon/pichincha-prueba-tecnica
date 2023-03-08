package com.globant.pruebatecnica.cuenta.service.domain.mapper;

import com.globant.pruebatecnica.cliente.service.domain.Constants;
import com.globant.pruebatecnica.cuenta.service.domain.dto.ReporteMovimientosResponse;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ReporteMovimientosResponseMapper {

  public ReporteMovimientosResponse toMovimiento(Movimiento movimiento) {
    if (movimiento == null) {
      return null;
    }
    return ReporteMovimientosResponse.builder()
        .tipo(movimiento.getTipoMovimiento())
        .fecha(movimiento.getFecha().toString())
        .cliente(movimiento.getCuenta().getCliente().getNombre())
        .estado(movimiento.getCuenta().getEstado())
        .numeroCuenta(movimiento.getCuenta().getNumeroCuenta())
        .saldoInicial(movimiento.getSaldo())
        .movimiento(movimiento.getTipoMovimiento().toUpperCase().equals(Constants.MOVIMIENTO_RETIRO) ?
            -1 * movimiento.getValor() :
            movimiento.getValor())
        .saldoDisponible(movimiento.getTipoMovimiento().toUpperCase().equals(Constants.MOVIMIENTO_RETIRO) ?
            movimiento.getSaldo() - movimiento.getValor() :
            movimiento.getSaldo() + movimiento.getValor())
        .build();
  }

  public Iterable<ReporteMovimientosResponse> toMovimientos(Iterable<Movimiento> movimientos) {
    return ((Collection<Movimiento>) movimientos).stream()
        .map(movimiento -> ReporteMovimientosResponse.builder()
            .tipo(movimiento.getTipoMovimiento())
            .fecha(movimiento.getFecha().toString())
            .cliente(movimiento.getCuenta().getCliente().getNombre())
            .estado(movimiento.getCuenta().getEstado())
            .numeroCuenta(movimiento.getCuenta().getNumeroCuenta())
            .saldoInicial(movimiento.getSaldo())
            .movimiento(movimiento.getTipoMovimiento().toUpperCase().equals(Constants.MOVIMIENTO_RETIRO) ?
                -1 * movimiento.getValor() :
                movimiento.getValor())
            .saldoDisponible(movimiento.getTipoMovimiento().toUpperCase().equals(Constants.MOVIMIENTO_RETIRO) ?
                movimiento.getSaldo() - movimiento.getValor() :
                movimiento.getSaldo() + movimiento.getValor())
            .build())
        .collect(Collectors.toList());
  }

}
