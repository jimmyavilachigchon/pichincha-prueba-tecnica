package com.globant.pruebatecnica.cuenta.service.domain.ports.input;

import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;

import java.util.Optional;

public interface CuentaService {

    Iterable<Cuenta> getCuentas();

    Optional<Cuenta> getCuentaById(Integer id);

    Cuenta save(Cuenta cuenta);

    Cuenta update(Cuenta cuenta);

    void deleteById(Integer id);

}