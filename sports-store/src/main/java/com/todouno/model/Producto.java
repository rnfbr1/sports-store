package com.todouno.model;

import com.todouno.dominio.EstadoProducto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by Fabricio on 02/09/2018.
 */

@Entity
@Table(
        name = "producto"
)
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull(message = "La descripcion del producto es obligatorio!")
    private String descripcion;
    @Column(nullable = false)
    @NotNull(message = "Marca es obligatoria!")
    private String marca;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoProducto estado;
    @Column(name="precio_unitario", nullable = false)
    @NotNull(message = "Precio es obligatorio!")
    private BigDecimal precioUnitario;
    @Column(name="fecha_creacion")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime fechaCreacion;

    public Producto() {}

    public Producto(@NotNull(message = "La descripcion del producto no puede ser nula!") String descripcion, @NotNull(message = "Marca no puede ser nula!") String marca, EstadoProducto estado, @NotNull(message = "Precio no puede ser nulo!") BigDecimal precioUnitario, ZonedDateTime fechaCreacion) {
        this.descripcion = descripcion;
        this.marca = marca;
        this.estado = estado;
        this.precioUnitario = precioUnitario;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public ZonedDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(ZonedDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
