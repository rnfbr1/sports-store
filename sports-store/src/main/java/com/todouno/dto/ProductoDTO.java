package com.todouno.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todouno.dominio.EstadoProducto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Fabricio on 02/09/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Descripcion es obligatorio!")
    private String descripcion;

    @NotNull(message = "Marca es obligatorio!")
    private String marca;

    @NotNull(message = "Estado es obligatorio!")
    private EstadoProducto estado;

    @NotNull(message = "Precio Unitario es obligatorio!")
    private BigDecimal precioUnitario;

    private ZonedDateTime fechaCreacion;



    public ProductoDTO() {}

    public ProductoDTO(Long id, @NotNull(message = "Descripcion es obligatorio!") String descripcion, @NotNull(message = "Marca es obligatorio!") String marca, @NotNull(message = "Estado es obligatorio!") EstadoProducto estado, @NotNull(message = "Precio Unitario es obligatorio!") BigDecimal precioUnitario, ZonedDateTime fechaCreacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = marca;
        this.estado = estado;
        this.precioUnitario = precioUnitario;
        this.fechaCreacion = fechaCreacion;

    }

    public static ProductoDTOBuilder newBuilder() {
        return new ProductoDTOBuilder();
    }

    @JsonProperty
    public Long getId()
    {
        return id;
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

    public static class ProductoDTOBuilder  {
        private Long id;
        private String descripcion;
        private String marca;
        private EstadoProducto estado;
        private BigDecimal precioUnitario;
        private ZonedDateTime fechaCreacion;

        public ProductoDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProductoDTOBuilder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public ProductoDTOBuilder setMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public ProductoDTOBuilder setEstado(EstadoProducto estado) {
            this.estado = estado;
            return this;
        }

        public ProductoDTOBuilder setPrecioUnitario(BigDecimal precioUnitario) {
            this.precioUnitario = precioUnitario;
            return this;
        }

        public ProductoDTOBuilder setFechaCreacion(ZonedDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public ProductoDTO crearProductoDTO()
        {
            return new ProductoDTO(id,  descripcion,  marca, estado,  precioUnitario, fechaCreacion);
        }
    }

}
