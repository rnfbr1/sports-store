package com.todouno.controller;

import com.todouno.dominio.EstadoEmpleado;
import com.todouno.dto.EmpleadoDTO;
import com.todouno.exception.ConstraintsViolationException;
import com.todouno.exception.EntityNotFoundException;
import com.todouno.mapper.EmpleadoMapper;
import com.todouno.model.Empleado;
import com.todouno.service.empleado.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Fabricio on 02/09/2018.
 */
@RestController
@RequestMapping("/sports-store/v1/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(final EmpleadoService empleadoService)
    {
        this.empleadoService = empleadoService;
    }


    @GetMapping("/")
    public List<EmpleadoDTO> getEmpleados() throws EntityNotFoundException {
        return EmpleadoMapper.transformarAListaDto(empleadoService.buscarTodos());
    }

    @GetMapping("/id/{empleadoId}")
    public EmpleadoDTO getEmpleadoPorId(@Valid @PathVariable Long empleadoId) throws EntityNotFoundException {
        return EmpleadoMapper.transformarEntidadADto(empleadoService.buscarPorId(empleadoId));
    }

    @GetMapping("/estado/{estadoEmpleado}")
    public List<EmpleadoDTO> getEmpleadoPorEstado(@Valid @PathVariable EstadoEmpleado estado) throws EntityNotFoundException {
        return EmpleadoMapper.transformarAListaDto(empleadoService.buscarPorEstado(estado));
    }

    @GetMapping("/nombre/{nombre}")
    public List<EmpleadoDTO> getEmpleadoPorNombre(@Valid @PathVariable String nombre) throws EntityNotFoundException {
        return EmpleadoMapper.transformarAListaDto(empleadoService.buscarPorNombre(nombre));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDTO crearEmpleado(@Valid @RequestBody EmpleadoDTO empleadoDTO) throws ConstraintsViolationException    {
        EmpleadoDTO dto = empleadoDTO;
        dto.setEstado(EstadoEmpleado.ACTIVO);
        Empleado empleado = EmpleadoMapper.transformarDtoAEntidad(dto);
        return EmpleadoMapper.transformarEntidadADto(empleadoService.crear(empleado));
    }





}
