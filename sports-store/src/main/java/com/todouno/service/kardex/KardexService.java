package com.todouno.service.kardex;

import com.todouno.dominio.TipoOperacion;
import com.todouno.exception.StockMenorACeroException;
import com.todouno.model.Kardex;
import com.todouno.model.Producto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
public interface KardexService {

    public List<Kardex> buscarPorTipoOperacion(TipoOperacion tipoOperacion);

    public List<Kardex> buscarPorProductoId(Long productoId);

    public Kardex crearIngreso(Kardex kardex) throws StockMenorACeroException;

    public Kardex crearSalida(Kardex kardex) throws StockMenorACeroException;

    public Kardex consultarStock(Long productoId);
}
