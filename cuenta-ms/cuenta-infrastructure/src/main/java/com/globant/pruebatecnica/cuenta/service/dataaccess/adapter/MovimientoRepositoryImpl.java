package com.globant.pruebatecnica.cuenta.service.dataaccess.adapter;

import com.globant.pruebatecnica.cuenta.service.dataaccess.entity.MovimientoEntity;
import com.globant.pruebatecnica.cuenta.service.dataaccess.mapper.MovimientoMapper;
import com.globant.pruebatecnica.cuenta.service.dataaccess.adapter.repository.MovimientoJpaRepositoryHelper;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Movimiento;
import com.globant.pruebatecnica.cuenta.service.domain.ports.output.MovimientoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@Slf4j
public class MovimientoRepositoryImpl implements MovimientoRepository {
  private MovimientoJpaRepositoryHelper movimientoJpaRepositoryHelper;

  @Autowired
  private MovimientoMapper movimientoMapper;

  public MovimientoRepositoryImpl(MovimientoJpaRepositoryHelper movimientoJpaRepositoryHelper) {
    this.movimientoJpaRepositoryHelper = movimientoJpaRepositoryHelper;
  }

  @Override
  public Iterable<Movimiento> getMovimientos(String numeroCuenta, LocalDate inicio, LocalDate fin) {
    return movimientoMapper.toMovimientos(
        this.movimientoJpaRepositoryHelper.findByNumeroCuentaAndFechaBetween(numeroCuenta, inicio, fin));
  }

  @Override
  public Optional<Movimiento> getMovimientoById(Integer id) {
    return Optional.ofNullable(
        this.movimientoMapper.toMovimiento(movimientoJpaRepositoryHelper.findById(id).get()));
  }

  @Override
  public Movimiento save(Movimiento movimiento) {
    MovimientoEntity movimientoEntity = this.movimientoMapper.toMovimientoEntity(movimiento);
    System.out.println(
        "Registrando movimiento para la cuenta con Id: " + movimientoEntity.getCuentaEntity()
            .getId());
    return this.movimientoMapper.toMovimiento(this.movimientoJpaRepositoryHelper.save(movimientoEntity));
  }

  @Override
  public Movimiento update(Movimiento movimiento) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
