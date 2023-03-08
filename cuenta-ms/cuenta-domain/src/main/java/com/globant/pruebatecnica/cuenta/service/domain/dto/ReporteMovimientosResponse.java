package com.globant.pruebatecnica.cuenta.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReporteMovimientosResponse {

  private String fecha;

  private String cliente;

  private String numeroCuenta;

  private String tipo;

  private Double saldoInicial;

  private Boolean estado;

  private Double movimiento;

  private Double saldoDisponible;

}
