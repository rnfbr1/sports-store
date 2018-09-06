package com.todouno.service.empleado;

import com.todouno.dao.EmpleadoRepository;
import com.todouno.dominio.EstadoEmpleado;
import com.todouno.dominio.RolEmpleado;
import com.todouno.exception.ConstraintsViolationException;
import com.todouno.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Fabricio on 02/09/2018.
 */
@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;


    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarPorId(Long empleadoId) throws EntityNotFoundException {
        Optional<Empleado> empleado = empleadoRepository.findById(empleadoId);
        if (empleado.isPresent()) {
            return empleado.get();
        }
        return null;
    }

    @Override
    public List<Empleado> buscarPorEstado(EstadoEmpleado estadoEmpleado) {
        return empleadoRepository.findByEstado(estadoEmpleado);
    }

    @Override
    public List<Empleado> buscarPorNombre(String nombre) {
        return empleadoRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Empleado> buscarPorRol(RolEmpleado rol) {
        return empleadoRepository.findByRol(rol);
    }

    @Override
    public Empleado crear(Empleado empleado) throws ConstraintsViolationException {

        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(Long empleadoId) throws EntityNotFoundException {
        Empleado empleado = new Empleado();
        Optional<Empleado> optionalEmpleado = empleadoRepository.findById(empleadoId);
        if (optionalEmpleado.isPresent()) {
            empleado = optionalEmpleado.get();
            empleado.setEstado(EstadoEmpleado.INACTIVO);
        } else {
            throw new EntityNotFoundException();
        }

    }
}
