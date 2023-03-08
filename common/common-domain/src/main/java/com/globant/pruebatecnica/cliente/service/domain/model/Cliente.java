package com.globant.pruebatecnica.cliente.service.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.globant.pruebatecnica.cliente.service.domain.exception.DomainException;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente extends Persona implements Serializable {

  private String password;
  private Boolean estado;

  public void validateData() {
    validateGenero();
    validatePassword();
  }

  private void validatePassword() {
    if (password == null) {
      throw new DomainException("El password no debe ser vacío.");
    }
    if (password.trim().length() < 8) {
      throw new DomainException("El password debe tener como minimo 8 caracteres");
    }
  }

  private void validateGenero() {
    if (genero == null) {
      throw new DomainException("El genero no debe ser vacío.");
    }
    if (!genero.equals("M") && !genero.equals("F")) {
      throw new DomainException("El genero debe tener valores M o F.");
    }
  }

  private Cliente(Builder builder) {
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

    public Cliente build() {
      return new Cliente(this);
    }
  }
}
