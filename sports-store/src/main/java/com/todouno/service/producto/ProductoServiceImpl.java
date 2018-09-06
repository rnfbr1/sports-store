package com.todouno.service.producto;

import com.todouno.dao.ProductoRepository;
import com.todouno.dominio.EstadoProducto;
import com.todouno.dto.ProductoDTO;
import com.todouno.exception.ConstraintsViolationException;
import com.todouno.mapper.ProductoMapper;
import com.todouno.model.Producto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by Fabricio on 02/09/2018.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(ProductoServiceImpl.class);

    @Autowired
    ProductoRepository productoRepository;


    @Override
    public List<Producto> buscarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarPorId(Long productoId) throws EntityNotFoundException {
        Optional<Producto> producto = productoRepository.findById(productoId);
        if (producto.isPresent()) {
            return producto.get();
        }
        return null;
    }

    @Override
    public List<Producto> buscarPorEstado(EstadoProducto estadoProducto) {
        return productoRepository.findByEstado(estadoProducto);
    }

    @Override
    public List<Producto> buscarPorDescripcion(String descripcion) {
        return productoRepository.findByDescripcionContainingOrderByDescripcionAsc(descripcion);
    }

    @Override
    public Producto crear(Producto producto) throws ConstraintsViolationException {

        return productoRepository.save(producto);

    }

    @Override
    public void eliminar(Long productoId) throws EntityNotFoundException {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoRepository.findById(productoId);
        if (optionalProducto.isPresent()) {
            producto = optionalProducto.get();
            producto.setEstado(EstadoProducto.DESACTIVADO);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public Producto actualizarProducto(Long id, ProductoDTO productoDTO) {
        Producto producto  = new Producto();
        Optional<Producto> opcionalProducto = productoRepository.findById(id);
        if (opcionalProducto.isPresent()) {
            producto = opcionalProducto.get();
            producto = ProductoMapper.obtenerProductoActualizar(producto, productoDTO);
            producto = productoRepository.save(producto);
        }

        return producto;
    }
}
