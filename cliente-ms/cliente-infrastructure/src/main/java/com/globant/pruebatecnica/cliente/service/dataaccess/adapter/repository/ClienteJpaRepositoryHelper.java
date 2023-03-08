package com.globant.pruebatecnica.cliente.service.dataaccess.adapter.repository;

import com.globant.pruebatecnica.dataaccess.cliente.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteJpaRepositoryHelper extends JpaRepository<ClienteEntity, Integer> {

    Optional<ClienteEntity> findByIdentificacion(String identificacion);
}
