package com.todouno.mapper;

import com.todouno.dto.ProductoDTO;
import com.todouno.model.Producto;
import org.springframework.util.StringUtils;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fabricio on 02/09/2018.
 */
public class ProductoMapper {
    public static Producto transformarDtoAEntidad(ProductoDTO productoDTO) {
        return new Producto(productoDTO.getDescripcion(), productoDTO.getMarca(), productoDTO.getEstado(), productoDTO.getPrecioUnitario(), productoDTO.getFechaCreacion());
    }


    public static ProductoDTO transformarEntidadADto(Producto producto) {
        ProductoDTO.ProductoDTOBuilder productoDTOBuilder = ProductoDTO.newBuilder()
                .setId(producto.getId())
                .setDescripcion(producto.getDescripcion())
                .setEstado(producto.getEstado())
                .setFechaCreacion(producto.getFechaCreacion())
                .setMarca(producto.getMarca())
                .setPrecioUnitario(producto.getPrecioUnitario());


        return productoDTOBuilder.crearProductoDTO();
    }


    public static List<ProductoDTO> transformarAListaDto(Collection<Producto> productos) {
        return productos.stream()
                .map(ProductoMapper::transformarEntidadADto)
                .collect(Collectors.toList());
    }

    public static Producto obtenerProductoActualizar(Producto producto, ProductoDTO productoDTO) {

        Producto productoActualizar = producto;
        ProductoDTO dto = productoDTO;

        if(!StringUtils.isEmpty(dto.getDescripcion())) {
            producto.setDescripcion(dto.getDescripcion());
        }
        if(!StringUtils.isEmpty(dto.getEstado())) {
            producto.setEstado(dto.getEstado());
        }
        if(!StringUtils.isEmpty(dto.getMarca())) {
            producto.setMarca(dto.getMarca());
        }
        if(!StringUtils.isEmpty(dto.getPrecioUnitario())) {
            producto.setPrecioUnitario(dto.getPrecioUnitario());
        }

        return producto;



    }
}
