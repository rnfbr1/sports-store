package com.todouno.dao;

import com.todouno.dominio.TipoOperacion;
import com.todouno.model.Kardex;
import com.todouno.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
@Component
public interface KardexRepository extends CrudRepository<Kardex, Long>{

    public List<Kardex> findByTipoOperacion(TipoOperacion tipoOperacion);

    public List<Kardex> findByProductoIdOrderByFechaOperacionDesc(Long productoId);

    public Kardex findFirstByProductoIdOrderByFechaOperacionDesc(Long productoId);


}
