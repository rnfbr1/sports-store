package com.todouno.model;

import com.todouno.dominio.TipoOperacion;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Fabricio on 02/09/2018.
 */

@Entity
@Table(name="kardex")
public class Kardex {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long identificacion;
    @OneToOne
    @JoinColumn(name="producto_id")
    private Producto producto;
    private Integer cantidad;
    @Min(value = 0, message = "El stock no puede ser valor negativo")
    private Integer stock;
    @Column(name="precio_unitario", nullable = false)
    @NotNull(message = "Precio es obligatorio!")
    private BigDecimal precioUnitario;
    @NotNull(message = "Total es obligatorio!")
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_operacion", nullable = false)
    @NotNull(message = "Tipo de operacion es obligatorio!")
    private TipoOperacion tipoOperacion;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime fechaOperacion;
    @OneToOne
    @NotNull(message = "Id de empleado es obligatorio!")
    @JoinColumn(name="empleado_id")
    private Empleado ingresadoPor;


    public Kardex() {
    }

    public Kardex(Producto producto, Integer cantidad, @Min(value = 0, message = "El stock no puede ser valor negativo") @NotNull(message = "Stock es obligatorio!") Integer stock, @NotNull(message = "Precio es obligatorio!") BigDecimal precioUnitario, BigDecimal total, @NotNull(message = "Tipo de operacion es obligatorio!") TipoOperacion tipoOperacion, ZonedDateTime fechaOperacion, @NotNull(message = "Id de empleado es obligatorio!") Empleado ingresadoPor) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.total = total;
        this.tipoOperacion = tipoOperacion;
        this.fechaOperacion = fechaOperacion;
        this.ingresadoPor = ingresadoPor;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    public Empleado getIngresadoPor() {
        return ingresadoPor;
    }

    public void setIngresadoPor(Empleado ingresadoPor) {
        this.ingresadoPor = ingresadoPor;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}


