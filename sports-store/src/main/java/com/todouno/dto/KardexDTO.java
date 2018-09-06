package com.todouno.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todouno.dominio.EstadoProducto;
import com.todouno.dominio.TipoOperacion;
import com.todouno.model.Empleado;
import com.todouno.model.Kardex;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Fabricio on 02/09/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KardexDTO {

    @JsonIgnore
    private Long identificacion;

    @NotNull(message = "Id del producto es obligatorio!")
    private Long productoId;

    @NotNull(message = "Cantidad es obligatorio!")
    private Integer cantidad;

    private Integer stock;

    private BigDecimal precioUnitario;

    private BigDecimal total;

    @NotNull(message = "Tipo de Operacion es obligatorio!")
    private TipoOperacion tipoOperacion;

    private ZonedDateTime fechaOperacion;

    @NotNull(message = "Empleado es obligatorio!")
    private Long empleadoId;


    public KardexDTO() {}

    public KardexDTO(Long identificacion, @NotNull(message = "Codigo de producto es obligatorio!") Long productoId, @NotNull(message = "Cantidad es obligatorio!") Integer cantidad,  Integer stock, @NotNull(message = "Precio Unitario es obligatorio!") BigDecimal precioUnitario,  BigDecimal total, @NotNull(message = "Tipo de Operacion es obligatorio!") TipoOperacion tipoOperacion, ZonedDateTime fechaOperacion, @NotNull(message = "Empleado es obligatorio!") Long empleadoId) {
        this.identificacion = identificacion;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.tipoOperacion = tipoOperacion;
        this.fechaOperacion = fechaOperacion;
        this.empleadoId = empleadoId;
    }

    public static KardexDTOBuilder newBuilder() {
        return new KardexDTOBuilder();
    }

    @JsonProperty
    public Long getIdentificacion() {
        return identificacion;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public ZonedDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(ZonedDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public static class KardexDTOBuilder  {
        private Long identificacion;
        private Long productoId;
        private Integer cantidad;
        private Integer stock;
        private BigDecimal precioUnitario;
        private BigDecimal total;
        private TipoOperacion tipoOperacion;
        private ZonedDateTime fechaOperacion;
        private Long empleadoId;

        public KardexDTOBuilder setIdentificacion(Long identificacion) {
            this.identificacion = identificacion;
            return this;
        }

        public KardexDTOBuilder setProductoId(Long productoId) {
            this.productoId = productoId;
            return this;
        }

        public KardexDTOBuilder setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public KardexDTOBuilder setStock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public KardexDTOBuilder setPrecioUnitario(BigDecimal precioUnitario) {
            this.precioUnitario = precioUnitario;
            return this;
        }

        public KardexDTOBuilder setTotal(BigDecimal total) {
            this.total = total;
            return this;
        }

        public KardexDTOBuilder setTipoOperacion(TipoOperacion tipoOperacion) {
            this.tipoOperacion = tipoOperacion;
            return this;
        }

        public KardexDTOBuilder setFechaOperacion(ZonedDateTime fechaOperacion) {
            this.fechaOperacion = fechaOperacion;
            return this;
        }

        public KardexDTOBuilder setEmpleadoId(Long empleadoId) {
            this.empleadoId = empleadoId;
            return this;
        }

        public KardexDTO crearKardexDTO()
        {
            return new KardexDTO(identificacion,  productoId,  cantidad, stock,  precioUnitario, total, tipoOperacion,fechaOperacion,empleadoId);
        }
    }

}
