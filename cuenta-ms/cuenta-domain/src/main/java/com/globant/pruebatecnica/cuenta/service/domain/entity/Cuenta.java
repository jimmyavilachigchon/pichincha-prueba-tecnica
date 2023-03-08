package com.globant.pruebatecnica.cuenta.service.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.globant.pruebatecnica.cliente.service.domain.model.Cliente;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cuenta implements Serializable {
  private Integer id;
  private String numeroCuenta;
  private String tipoCuenta;
  private Double saldoInicial;
  private Boolean estado;
  private Cliente cliente;

  private Cuenta(Builder builder) {
    setId(builder.id);
    setNumeroCuenta(builder.numeroCuenta);
    setTipoCuenta(builder.tipoCuenta);
    setSaldoInicial(builder.saldoInicial);
    setEstado(builder.estado);
    setCliente(builder.cliente);
  }
  public static final class Builder {
    private Integer id;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private Cliente cliente;

    public Builder() {
    }

    public Builder id(Integer val) {
      id = val;
      return this;
    }

    public Builder numeroCuenta(String val) {
      numeroCuenta = val;
      return this;
    }

    public Builder tipoCuenta(String val) {
      tipoCuenta = val;
      return this;
    }

    public Builder saldoInicial(Double val) {
      saldoInicial = val;
      return this;
    }

    public Builder estado(Boolean val) {
      estado = val;
      return this;
    }

    public Builder cliente(Cliente val) {
      cliente = val;
      return this;
    }

    public Cuenta build() {
      return new Cuenta(this);
    }
  }
}
