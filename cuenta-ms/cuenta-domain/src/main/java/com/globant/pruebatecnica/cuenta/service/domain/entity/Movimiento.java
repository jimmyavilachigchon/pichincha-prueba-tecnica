package com.globant.pruebatecnica.cuenta.service.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.globant.pruebatecnica.cliente.service.domain.Constants;
import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movimiento implements Serializable {

  private Integer id;
  private LocalDate fecha;
  private String tipoMovimiento;
  private Double valor;
  private Double saldo;
  private Cuenta cuenta;

  public void validateData() {
    validateSaldo();
  }

  private void validateSaldo() {
    saldo = cuenta.getSaldoInicial();
    if (tipoMovimiento.trim().toUpperCase().equals(Constants.MOVIMIENTO_RETIRO)) {
      if (cuenta.getSaldoInicial() == 0.00) {
        throw new DomainException("No se puede realizar el Retiro, el saldo es CERO.");
      }
      if (cuenta.getSaldoInicial() < valor) {
        throw new DomainException("La cuenta tiene saldo insuficiente.");
      }
      cuenta.setSaldoInicial(cuenta.getSaldoInicial() - valor);
    } else {
      cuenta.setSaldoInicial(cuenta.getSaldoInicial() + valor);
    }
  }

  private Movimiento(Builder builder) {
    setId(builder.id);
    setFecha(builder.fecha);
    setTipoMovimiento(builder.tipoMovimiento);
    setValor(builder.valor);
    setSaldo(builder.saldo);
    setCuenta(builder.cuenta);
  }

  public static final class Builder {
    private Integer id;
    private LocalDate fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;
    private Cuenta cuenta;

    public Builder() {
    }

    public Builder id(Integer val) {
      id = val;
      return this;
    }

    public Builder fecha(LocalDate val) {
      fecha = val;
      return this;
    }

    public Builder tipoMovimiento(String val) {
      tipoMovimiento = val;
      return this;
    }

    public Builder valor(Double val) {
      valor = val;
      return this;
    }

    public Builder saldo(Double val) {
      saldo = val;
      return this;
    }

    public Builder cuenta(Cuenta val) {
      cuenta = val;
      return this;
    }

    public Movimiento build() {
      return new Movimiento(this);
    }
  }
}