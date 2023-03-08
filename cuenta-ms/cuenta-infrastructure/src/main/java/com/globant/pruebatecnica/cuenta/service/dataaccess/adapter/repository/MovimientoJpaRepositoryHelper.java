package com.globant.pruebatecnica.cuenta.service.dataaccess.adapter.repository;

import com.globant.pruebatecnica.cuenta.service.dataaccess.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovimientoJpaRepositoryHelper extends JpaRepository<MovimientoEntity, Integer> {

  @Query("SELECT m FROM MovimientoEntity m INNER JOIN m.cuentaEntity c " +
      "WHERE c.numeroCuenta = :numeroCuenta and fecha between :inicio and :fin")
  List<MovimientoEntity> findByNumeroCuentaAndFechaBetween(String numeroCuenta, LocalDate inicio,
                                                           LocalDate fin);
}
