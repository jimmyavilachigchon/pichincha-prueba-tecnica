package com.globant.pruebatecnica.cliente.service.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode()
public abstract class Persona implements Serializable {
    @EqualsAndHashCode.Include
    private Integer id;

    @JsonProperty("nombre")
    @NotBlank(message = "Debe ingresar el nombre")
    @Min(5)
    @Max(100)
    protected String nombre;
    protected String genero;
    protected Integer edad;
    protected String identificacion;
    protected String direccion;
    protected String telefono;

}