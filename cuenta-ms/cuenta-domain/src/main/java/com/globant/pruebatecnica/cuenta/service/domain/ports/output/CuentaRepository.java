package com.globant.pruebatecnica.cuenta.service.domain.ports.output;

import com.globant.pruebatecnica.cuenta.service.domain.entity.Cuenta;

import java.util.Optional;

public interface CuentaRepository {

    Iterable<Cuenta> getCuentas();

    Optional<Cuenta> getCuentaById(Integer id);

    Optional<Cuenta> getCuentaByNumeroCuenta(String numeroCuenta);

    Cuenta save(Cuenta cuenta);

    void delete(Cuenta cuenta);

}
