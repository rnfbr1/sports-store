package com.todouno.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todouno.dominio.EstadoEmpleado;
import com.todouno.dominio.EstadoProducto;
import com.todouno.dominio.RolEmpleado;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Fabricio on 02/09/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpleadoDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Nombre es obligatorio!")
    private String nombre;

    private RolEmpleado rol;

    private EstadoEmpleado estado;

    @JsonProperty
    public Long getId()
    {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    public EstadoEmpleado getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpleado estado) {
        this.estado = estado;
    }

    public EmpleadoDTO() {}

    public EmpleadoDTO(Long id, @NotNull(message = "Nombre es obligatorio") String nombre, RolEmpleado rol, @NotNull(message = "Estado es obligatorio") EstadoEmpleado estado) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.estado = estado;
    }

    public static EmpleadoDTOBuilder newBuilder() {
        return new EmpleadoDTOBuilder();
    }

    public static class EmpleadoDTOBuilder  {
        private Long id;
        private String nombre;
        private RolEmpleado rol;
        private EstadoEmpleado estado;
        private BigDecimal precioUnitario;
        private ZonedDateTime fechaCreacion;

        public EmpleadoDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public EmpleadoDTOBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EmpleadoDTOBuilder setRol(RolEmpleado rol) {
            this.rol = rol;
            return this;
        }

        public EmpleadoDTOBuilder setEstadoEmpleado(EstadoEmpleado estado) {
            this.estado = estado;
            return this;
        }

        public EmpleadoDTO crearEmpleadoDTO()
        {
            return new EmpleadoDTO(id,  nombre,  rol, estado);
        }
    }

}
