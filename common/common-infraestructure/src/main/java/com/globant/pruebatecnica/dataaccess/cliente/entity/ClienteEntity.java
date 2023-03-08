package com.globant.pruebatecnica.dataaccess.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "cliente")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity extends PersonaEntity implements Serializable {

    private String password;
    private Boolean estado;

    private ClienteEntity(Builder builder) {
        setPassword(builder.password);
        setEstado(builder.estado);
        setId(builder.id);
        setNombre(builder.nombre);
        setGenero(builder.genero);
        setEdad(builder.edad);
        setIdentificacion(builder.identificacion);
        setDireccion(builder.direccion);
        setTelefono(builder.telefono);
    }
    public static final class Builder {
        private String password;
        private Boolean estado;
        private Integer id;
        private String nombre;
        private String genero;
        private Integer edad;
        private String identificacion;
        private String direccion;
        private String telefono;

        public Builder() {
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder estado(Boolean val) {
            estado = val;
            return this;
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder nombre(String val) {
            nombre = val;
            return this;
        }

        public Builder genero(String val) {
            genero = val;
            return this;
        }

        public Builder edad(Integer val) {
            edad = val;
            return this;
        }

        public Builder identificacion(String val) {
            identificacion = val;
            return this;
        }

        public Builder direccion(String val) {
            direccion = val;
            return this;
        }

        public Builder telefono(String val) {
            telefono = val;
            return this;
        }

        public ClienteEntity build() {
            return new ClienteEntity(this);
        }
    }
}