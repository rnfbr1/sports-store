package com.todouno.dao;

import com.todouno.dominio.EstadoEmpleado;
import com.todouno.dominio.RolEmpleado;
import com.todouno.model.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
@Component
public interface EmpleadoRepository extends CrudRepository<Empleado,Long>{

    public List<Empleado> findAll();

    public List<Empleado> findByEstado(EstadoEmpleado estado);

    public List<Empleado> findByNombreContaining(String nombre);

    public List<Empleado> findByRol(RolEmpleado rol);


}
