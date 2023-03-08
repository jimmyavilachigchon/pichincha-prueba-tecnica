package com.globant.pruebatecnica.cuenta.service.dataaccess.entity;

import com.globant.pruebatecnica.dataaccess.cliente.entity.ClienteEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "cuenta")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CuentaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    Integer id;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClienteEntity clienteEntity;

    private CuentaEntity(Builder builder) {
        setId(builder.id);
        setNumeroCuenta(builder.numeroCuenta);
        setTipoCuenta(builder.tipoCuenta);
        setSaldoInicial(builder.saldoInicial);
        setEstado(builder.estado);
        setClienteEntity(builder.clienteEntity);
    }

    public static final class Builder {
        private Integer id;
        private String numeroCuenta;
        private String tipoCuenta;
        private Double saldoInicial;
        private Boolean estado;
        private ClienteEntity clienteEntity;

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

        public Builder clienteEntity(ClienteEntity val) {
            clienteEntity = val;
            return this;
        }

        public CuentaEntity build() {
            return new CuentaEntity(this);
        }
    }
}
