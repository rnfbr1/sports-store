package com.todouno.service.producto;

import com.todouno.dominio.EstadoProducto;
import com.todouno.dto.ProductoDTO;
import com.todouno.exception.ConstraintsViolationException;
import com.todouno.model.Producto;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
public interface ProductoService {

    /***
     * Busca todos los productos
     * @return
     */
    public List<Producto> buscarTodos();

    /***
     * Busca un producto por identificacion
     * @param productoId
     * @return Producto
     * @throws EntityNotFoundException
     */
    public Producto buscarPorId(Long productoId) throws EntityNotFoundException;

    /***
     * Busca productos por su estado
     * @param estadoProducto
     * @return List
     */
    public List<Producto> buscarPorEstado(EstadoProducto estadoProducto);

    /***
     * Busca productos por su descripcion
     * @param descripcion
     * @return List
     */
    public List<Producto> buscarPorDescripcion(String descripcion);

    /***
     * Crea un producto nuevo
     * @param producto
     * @return Producto
     * @throws ConstraintsViolationException
     */
    public Producto crear(Producto producto) throws ConstraintsViolationException;

    /***
     * Eliminacion logica de un producto
     * @param productoId
     * @throws EntityNotFoundException
     */
    void eliminar(Long productoId) throws EntityNotFoundException;

    /***
     * Actualiza precio de producto
     * @param id
     * @param productoDTO
     * @return Producto
     */
    public Producto actualizarProducto(Long id, ProductoDTO productoDTO);

}
