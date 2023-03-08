package com.globant.pruebatecnica.cuenta.service.dataaccess.adapter.repository;

import com.globant.pruebatecnica.cuenta.service.dataaccess.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaJpaRepositoryHelper extends JpaRepository<CuentaEntity, Integer> {

    Optional<CuentaEntity> findByNumeroCuenta(String numeroCuenta);
}
