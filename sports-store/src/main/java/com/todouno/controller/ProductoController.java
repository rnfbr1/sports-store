package com.todouno.controller;

import com.todouno.dominio.EstadoProducto;
import com.todouno.dto.ProductoDTO;
import com.todouno.exception.ConstraintsViolationException;
import com.todouno.exception.EntityNotFoundException;
import com.todouno.mapper.ProductoMapper;
import com.todouno.model.Producto;
import com.todouno.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by Fabricio on 02/09/2018.
 */
@RestController
@RequestMapping("/sports-store/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(final ProductoService productoService)
    {
        this.productoService = productoService;
    }

    @GetMapping("/")
    public List<ProductoDTO> getProductos() throws EntityNotFoundException {
        return ProductoMapper.transformarAListaDto(productoService.buscarTodos());
    }

    @GetMapping("/id/{productoId}")
    public ProductoDTO getProductoPorId(@Valid @PathVariable Long productoId) throws EntityNotFoundException {
        return ProductoMapper.transformarEntidadADto(productoService.buscarPorId(productoId));
    }

    @GetMapping("/estado/{estadoProducto}")
    public List<ProductoDTO> getProductoPorEstado(@Valid @PathVariable EstadoProducto estadoProducto) throws EntityNotFoundException {
        return ProductoMapper.transformarAListaDto(productoService.buscarPorEstado(estadoProducto));
    }

    @GetMapping("/descripcion/{descripcion}")
    public List<ProductoDTO> getProductoPorDescripcion(@Valid @PathVariable String descripcion) throws EntityNotFoundException {
        return ProductoMapper.transformarAListaDto(productoService.buscarPorDescripcion(descripcion));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDTO crearProducto(@Valid @RequestParam ProductoDTO productoDTO) throws ConstraintsViolationException
    {
        ProductoDTO dto = productoDTO;
        dto.setFechaCreacion(ZonedDateTime.now());
        Producto producto = ProductoMapper.transformarDtoAEntidad(dto);
        return ProductoMapper.transformarEntidadADto(productoService.crear(producto));
    }

    @PutMapping("/id/{id}")
    public ProductoDTO actualizarPrecioUnitario(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        return ProductoMapper.transformarEntidadADto(productoService.actualizarProducto(id, productoDTO));
    }

}
