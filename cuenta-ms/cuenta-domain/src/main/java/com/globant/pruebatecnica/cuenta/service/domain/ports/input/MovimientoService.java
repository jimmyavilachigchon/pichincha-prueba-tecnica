package com.globant.pruebatecnica.cuenta.service.domain.ports.input;

import com.globant.pruebatecnica.cuenta.service.domain.dto.ReporteMovimientosResponse;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;

import java.time.LocalDate;
import java.util.Optional;

public interface MovimientoService {
  Iterable<ReporteMovimientosResponse> getMovimientos(String numeroCuenta, LocalDate inicio, LocalDate fin);

  Optional<Movimiento> getMovimientoById(Integer id);

  Movimiento save(Movimiento movimiento);

  Movimiento update(Movimiento movimiento);

  void deleteById(Integer id);
}