package com.todouno.service.kardex;

import com.todouno.dao.KardexRepository;
import com.todouno.dao.ProductoRepository;
import com.todouno.dominio.TipoOperacion;
import com.todouno.exception.StockMenorACeroException;
import com.todouno.model.Kardex;
import com.todouno.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
@Service
public class KardexServiceImpl implements KardexService {

    @Autowired
    KardexRepository kardexRepository;

    @Override
    public List<Kardex> buscarPorTipoOperacion(TipoOperacion tipoOperacion) {
        return kardexRepository.findByTipoOperacion(tipoOperacion);
    }

    @Override
    public List<Kardex> buscarPorProductoId(Long productoId) {
        return kardexRepository.findByProductoIdOrderByFechaOperacionDesc(productoId);

    }

    @Override
    public Kardex crearIngreso(Kardex kardex) throws StockMenorACeroException {
        Kardex ingreso = kardex;
        Kardex stockAnterior = this.consultarStock(ingreso.getProducto().getId());
        Integer nuevoStock = stockAnterior.getStock() + ingreso.getCantidad();
        if (nuevoStock < 0) {
            throw new StockMenorACeroException("Operación invalida: El stock no puede ser negativo. Stock actual: " + stockAnterior.getStock());
        }

        BigDecimal totalAnterior = stockAnterior.getTotal();
        BigDecimal subtotal = kardex.getPrecioUnitario().multiply(BigDecimal.valueOf(ingreso.getCantidad()));
        BigDecimal nuevoTotal = totalAnterior.add(subtotal);
        ingreso.setStock(nuevoStock);
        ingreso.setTotal(nuevoTotal);
        ingreso.setTipoOperacion(TipoOperacion.ENTRADA);
        return kardexRepository.save(ingreso);
    }

    @Override
    public Kardex crearSalida(Kardex kardex) throws StockMenorACeroException {
        Kardex salida = kardex;
        Kardex stockAnterior = this.consultarStock(salida.getProducto().getId());
        Integer nuevoStock = stockAnterior.getStock() - salida.getCantidad();
        if (nuevoStock < 0) {
            throw new StockMenorACeroException("Operación invalida: Ha sobrepasado el stock actual " + stockAnterior.getStock());
        }

        BigDecimal totalAnterior = stockAnterior.getTotal();
        BigDecimal subtotal = kardex.getPrecioUnitario().multiply(BigDecimal.valueOf(salida.getCantidad()));
        BigDecimal nuevoTotal = totalAnterior.subtract(subtotal);
        salida.setStock(nuevoStock);
        salida.setTotal(nuevoTotal);
        salida.setTipoOperacion(TipoOperacion.SALIDA);
        return kardexRepository.save(salida);
    }

    @Override
    public Kardex consultarStock(Long productoId) {
        Kardex kardex = kardexRepository.findFirstByProductoIdOrderByFechaOperacionDesc(productoId);
        return kardex;
    }
}
