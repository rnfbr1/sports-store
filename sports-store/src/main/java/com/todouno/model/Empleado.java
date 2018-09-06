package com.todouno.model;

import com.todouno.dominio.EstadoEmpleado;
import com.todouno.dominio.EstadoProducto;
import com.todouno.dominio.RolEmpleado;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Fabricio on 02/09/2018.
 */

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull(message = "El nombre del empleado es obligatorio")
    private String nombre;
    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "El estado del empleado es obligatorio")
    private EstadoEmpleado estado;

    public Empleado() {}

    public Empleado(@NotNull(message = "El nombre del empleado es obligatorio") String nombre, RolEmpleado rol, @NotNull(message = "El estado del empleado es obligatorio") EstadoEmpleado estado) {
        this.nombre = nombre;
        this.rol = rol;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
