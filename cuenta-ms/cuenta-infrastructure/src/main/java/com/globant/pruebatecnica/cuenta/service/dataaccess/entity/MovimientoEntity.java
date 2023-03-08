package com.globant.pruebatecnica.cuenta.service.dataaccess.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "movimiento")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Integer id;
  private LocalDate fecha;
  private String tipoMovimiento;
  private Double valor;
  private Double saldo;
  @JoinColumn(name = "cuenta_id", referencedColumnName = "id", updatable = true)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CuentaEntity cuentaEntity;

  private MovimientoEntity(Builder builder) {
    setId(builder.id);
    setFecha(builder.fecha);
    setTipoMovimiento(builder.tipoMovimiento);
    setValor(builder.valor);
    setSaldo(builder.saldo);
    setCuentaEntity(builder.cuentaEntity);
  }


  public static final class Builder {
    private Integer id;
    private LocalDate fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;
    private CuentaEntity cuentaEntity;

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

    public Builder cuentaEntity(CuentaEntity val) {
      cuentaEntity = val;
      return this;
    }

    public MovimientoEntity build() {
      return new MovimientoEntity(this);
    }
  }
}