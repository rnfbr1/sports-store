package com.todouno.controller;

import com.todouno.dominio.TipoOperacion;
import com.todouno.dto.KardexDTO;
import com.todouno.exception.ConstraintsViolationException;
import com.todouno.exception.EntityNotFoundException;
import com.todouno.exception.StockMenorACeroException;
import com.todouno.mapper.KardexMapper;
import com.todouno.model.Kardex;
import com.todouno.model.Producto;
import com.todouno.service.kardex.KardexService;
import com.todouno.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
@RestController
@RequestMapping("/sports-store/v1/kardex")
public class KardexController {

    private final KardexService kardexService;

    private final ProductoService productoService;

    @Autowired
    public KardexController(final KardexService kardexService, ProductoService productoService)
    {
        this.kardexService = kardexService;
        this.productoService = productoService;
    }


    @GetMapping("/productoId/{productoId}")
    public List<KardexDTO> getKardexPorProductoId(@Valid @PathVariable Long productoId) throws EntityNotFoundException {
        return KardexMapper.transformarAListaDto(kardexService.buscarPorProductoId(productoId));
    }

    @GetMapping("/tipoOperacion/{tipoOperacion}")
    public List<KardexDTO> getKardexPorTipoOperacion(@RequestParam TipoOperacion tipoOperacion) throws EntityNotFoundException {
        return KardexMapper.transformarAListaDto(kardexService.buscarPorTipoOperacion(tipoOperacion));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KardexDTO crearMovimiento(@Valid @RequestBody KardexDTO kardexDTO) throws ConstraintsViolationException, StockMenorACeroException {
        KardexDTO dto = kardexDTO;
        dto.setFechaOperacion(ZonedDateTime.now());
        Producto producto = productoService.buscarPorId(kardexDTO.getProductoId());
        if (null != producto.getId()) {
            dto.setPrecioUnitario(producto.getPrecioUnitario());
            Kardex kardex = KardexMapper.transformarDtoAEntidad(dto);
            //kardex.setProducto(producto);



            if (kardexDTO.getTipoOperacion().equals(TipoOperacion.ENTRADA)) {
                return KardexMapper.transformarEntidadADto(kardexService.crearIngreso(kardex));
            } else {
                return KardexMapper.transformarEntidadADto(kardexService.crearSalida(kardex));
            }


         }
        return dto;

     }

}
