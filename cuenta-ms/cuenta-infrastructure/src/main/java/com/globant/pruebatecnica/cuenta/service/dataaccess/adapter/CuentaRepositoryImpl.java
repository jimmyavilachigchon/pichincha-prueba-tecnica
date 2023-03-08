package com.globant.pruebatecnica.cuenta.service.dataaccess.adapter;

import com.globant.pruebatecnica.cuenta.service.dataaccess.entity.CuentaEntity;
import com.globant.pruebatecnica.cuenta.service.dataaccess.mapper.CuentaMapper;
import com.globant.pruebatecnica.cuenta.service.dataaccess.adapter.repository.CuentaJpaRepositoryHelper;
import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.cuenta.service.domain.ports.output.CuentaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class CuentaRepositoryImpl implements CuentaRepository {

  private final CuentaJpaRepositoryHelper cuentaJpaRepositoryHelper;

  @Autowired
  private CuentaMapper cuentaMapper;


  public CuentaRepositoryImpl(CuentaJpaRepositoryHelper cuentaJpaRepositoryHelper) {
    this.cuentaJpaRepositoryHelper = cuentaJpaRepositoryHelper;
  }

  @Override
  public Iterable<Cuenta> getCuentas() {
    return cuentaMapper.toCuentas(cuentaJpaRepositoryHelper.findAll());
  }

  @Override
  public Optional<Cuenta> getCuentaById(Integer id) {
    CuentaEntity cuentaEntity = this.cuentaJpaRepositoryHelper.findById(id).orElse(null);
    return Optional.ofNullable(this.cuentaMapper.toCuenta(cuentaEntity));
  }

  @Override
  public Optional<Cuenta> getCuentaByNumeroCuenta(String numeroCuenta) {
    CuentaEntity cuentaEntity = this.cuentaJpaRepositoryHelper.findByNumeroCuenta(numeroCuenta).orElse(null);
    return Optional.ofNullable(this.cuentaMapper.toCuenta(cuentaEntity));
  }

  @Override
  public Cuenta save(Cuenta cuenta) {
    CuentaEntity cuentaEntity = this.cuentaMapper.toCuentaEntity(cuenta);
    System.out.println("Registrando cuenta con numero: " + cuentaEntity.getNumeroCuenta());
    return this.cuentaMapper.toCuenta(this.cuentaJpaRepositoryHelper.save(cuentaEntity));
  }

  @Override
  public void delete(Cuenta cuenta) {
    this.cuentaJpaRepositoryHelper.delete(this.cuentaMapper.toCuentaEntity(cuenta));
  }
}
