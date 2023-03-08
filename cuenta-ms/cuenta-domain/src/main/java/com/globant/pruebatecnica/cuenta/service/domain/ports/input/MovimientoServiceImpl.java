package com.globant.pruebatecnica.cuenta.service.domain.ports.input;

import com.globant.pruebatecnica.cuenta.service.domain.dto.ReporteMovimientosResponse;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;
import com.globant.pruebatecnica.cuenta.service.domain.mapper.ReporteMovimientosResponseMapper;
import com.globant.pruebatecnica.cuenta.service.domain.ports.input.MovimientoService;
import com.globant.pruebatecnica.cuenta.service.domain.ports.output.CuentaRepository;
import com.globant.pruebatecnica.cuenta.service.domain.ports.output.MovimientoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Validated
@Service
public class MovimientoServiceImpl implements MovimientoService {

  private MovimientoRepository movimientoRepository;

  private CuentaRepository cuentaRepository;

  @Autowired
  private ReporteMovimientosResponseMapper mapper;
  public MovimientoServiceImpl(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
    this.movimientoRepository = movimientoRepository;
    this.cuentaRepository = cuentaRepository;
  }

  @Override
  public Iterable<ReporteMovimientosResponse> getMovimientos(String numeroCuenta, LocalDate inicio, LocalDate fin) {
    Iterable<Movimiento> movimientos = this.movimientoRepository.getMovimientos(numeroCuenta,
        inicio, fin);
    return mapper.toMovimientos(movimientos);
  }

  @Override
  public Optional<Movimiento> getMovimientoById(Integer id) {
    return this.movimientoRepository.getMovimientoById(id);
  }

  @Override
  public Movimiento save(Movimiento movimiento) {
    Optional<Cuenta> cuenta = cuentaRepository.getCuentaById(movimiento.getCuenta().getId());
    movimiento.setCuenta(cuenta.get());
    movimiento.validateData();
    this.cuentaRepository.save(movimiento.getCuenta());
    return this.movimientoRepository.save(movimiento);
  }

  @Override
  public Movimiento update(Movimiento movimiento) {
    return this.movimientoRepository.update(movimiento);
  }

  @Override
  public void deleteById(Integer id) {
    this.movimientoRepository.deleteById(id);
  }
}