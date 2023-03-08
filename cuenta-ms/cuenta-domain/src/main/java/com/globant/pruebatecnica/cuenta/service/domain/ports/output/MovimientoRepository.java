package com.globant.pruebatecnica.cuenta.service.domain.ports.output;

import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;

import java.time.LocalDate;
import java.util.Optional;

public interface MovimientoRepository {

  Iterable<Movimiento> getMovimientos(String numeroCuenta, LocalDate inicio, LocalDate fin);

  Optional<Movimiento> getMovimientoById(Integer id);

  Movimiento save(Movimiento movimiento);

  Movimiento update(Movimiento movimiento);

  void deleteById(Integer id);

}
