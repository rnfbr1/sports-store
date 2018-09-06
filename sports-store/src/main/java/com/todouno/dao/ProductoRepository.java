package com.todouno.dao;

import com.todouno.dominio.EstadoProducto;
import com.todouno.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
@Component
public interface ProductoRepository extends CrudRepository<Producto,Long> {

    public List<Producto> findAll();

    public List<Producto> findByEstado(EstadoProducto estadoProducto);

    public List<Producto> findByDescripcionContainingOrderByDescripcionAsc(String descripcion);


}
