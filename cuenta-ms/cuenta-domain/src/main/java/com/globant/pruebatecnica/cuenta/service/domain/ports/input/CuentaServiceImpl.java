package com.globant.pruebatecnica.cuenta.service.domain.ports.input;

import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;
import com.globant.pruebatecnica.cuenta.service.domain.exception.CuentaDomainException;
import com.globant.pruebatecnica.cuenta.service.domain.ports.input.CuentaService;
import com.globant.pruebatecnica.cuenta.service.domain.ports.output.CuentaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Slf4j
@Validated
@Service
public class CuentaServiceImpl implements CuentaService {
  @Autowired
  private CuentaRepository cuentaRepository;

  public CuentaServiceImpl(CuentaRepository cuentaRepository) {
    this.cuentaRepository = cuentaRepository;
  }

  @Override
  public Iterable<Cuenta> getCuentas() {
    return this.cuentaRepository.getCuentas();
  }

  @Override
  public Optional<Cuenta> getCuentaById(Integer id) {
    return this.cuentaRepository.getCuentaById(id);
  }

  @Override
  public Cuenta save(Cuenta cuenta) {
    if (this.cuentaRepository.getCuentaByNumeroCuenta(cuenta.getNumeroCuenta()).isPresent()) {
      throw new CuentaDomainException("El cuenta con numero " + cuenta.getNumeroCuenta() + " ya existe.");
    } else {
      return this.cuentaRepository.save(cuenta);
    }
  }

  @Override
  public Cuenta update(Cuenta cuenta) {
    return this.cuentaRepository.save(cuenta);
  }

  @Override
  public void deleteById(Integer id) {
    Optional<Cuenta> cuenta = this.cuentaRepository.getCuentaById(id);
    if (cuenta.isEmpty()) {
      throw new CuentaDomainException("El cuenta con Id " + id + " no existe.");
    } else {
      this.cuentaRepository.delete(cuenta.get());
    }
  }
}