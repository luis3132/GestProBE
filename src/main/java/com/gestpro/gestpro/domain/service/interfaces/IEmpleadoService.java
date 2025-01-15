package com.gestpro.gestpro.domain.service.interfaces;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.empleado.EmpleadoNuevoDTO;
import com.gestpro.gestpro.persistence.entity.Empleado;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public interface IEmpleadoService {
    public Optional<Empleado> getById(String id);
    public Empleado saveEmpleado(EmpleadoNuevoDTO empleado);
    public Boolean delete(String id);
    public Empleado update(EmpleadoNuevoDTO empleado);
}
