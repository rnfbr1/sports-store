package com.todouno.mapper;

import com.todouno.dto.EmpleadoDTO;
import com.todouno.dto.ProductoDTO;
import com.todouno.model.Empleado;
import com.todouno.model.Producto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fabricio on 02/09/2018.
 */
public class EmpleadoMapper {
    public static Empleado transformarDtoAEntidad(EmpleadoDTO empleadoDTO)
    {

        return new Empleado(empleadoDTO.getNombre(), empleadoDTO.getRol(),empleadoDTO.getEstado());
    }


    public static EmpleadoDTO transformarEntidadADto(Empleado empleado)
    {
        EmpleadoDTO.EmpleadoDTOBuilder empleadoDTOBuilder = EmpleadoDTO.newBuilder()
                .setId(empleado.getId())
                .setNombre(empleado.getNombre())
                .setEstadoEmpleado(empleado.getEstado())
                .setRol(empleado.getRol());

        return empleadoDTOBuilder.crearEmpleadoDTO();
    }


    public static List<EmpleadoDTO> transformarAListaDto(Collection<Empleado> empleados)
    {
        return empleados.stream()
                .map(EmpleadoMapper::transformarEntidadADto)
                .collect(Collectors.toList());
    }
}
