package com.todouno.mapper;

import com.todouno.dto.KardexDTO;
import com.todouno.dto.ProductoDTO;
import com.todouno.model.Empleado;
import com.todouno.model.Kardex;
import com.todouno.model.Producto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fabricio on 02/09/2018.
 */
public class KardexMapper {
    public static Kardex transformarDtoAEntidad(KardexDTO kardexDTO)
    {
        Producto producto = new Producto();
        producto.setId(kardexDTO.getProductoId());
        Empleado empleado = new Empleado();
        empleado.setId(kardexDTO.getEmpleadoId());
        return new Kardex(producto, kardexDTO.getCantidad(),kardexDTO.getStock(),kardexDTO.getPrecioUnitario(),kardexDTO.getTotal(),
                kardexDTO.getTipoOperacion(),kardexDTO.getFechaOperacion(),empleado);
    }


    public static KardexDTO transformarEntidadADto(Kardex kardex)
    {
        KardexDTO.KardexDTOBuilder kardexDTOBuilder = KardexDTO.newBuilder()
                .setProductoId(kardex.getProducto().getId())
                .setIdentificacion(kardex.getIdentificacion())
                .setCantidad(kardex.getCantidad())
                .setStock(kardex.getStock())
                .setPrecioUnitario(kardex.getPrecioUnitario())
                .setTotal(kardex.getTotal())
                .setTipoOperacion(kardex.getTipoOperacion())
                .setFechaOperacion(kardex.getFechaOperacion())
                .setEmpleadoId(kardex.getIngresadoPor().getId());




        return kardexDTOBuilder.crearKardexDTO();
    }


    public static List<KardexDTO> transformarAListaDto(Collection<Kardex> kardexes)
    {
        return kardexes.stream()
                .map(KardexMapper::transformarEntidadADto)
                .collect(Collectors.toList());
    }
}
