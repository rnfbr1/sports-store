package com.todouno.service.empleado;

import com.todouno.dominio.EstadoEmpleado;
import com.todouno.dominio.RolEmpleado;
import com.todouno.exception.ConstraintsViolationException;
import com.todouno.model.Empleado;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
public interface EmpleadoService {

    List<Empleado> buscarTodos();

    Empleado buscarPorId(Long empleadoId) throws EntityNotFoundException;


    List<Empleado> buscarPorEstado(EstadoEmpleado estadoEmpleado);


    List<Empleado> buscarPorNombre(String nombre);


    List<Empleado> buscarPorRol(RolEmpleado rolEmpleado);


    Empleado crear(Empleado empleado) throws ConstraintsViolationException;


    void eliminar(Long empleadoId) throws EntityNotFoundException;




}
