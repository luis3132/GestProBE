package com.gestpro.gestpro.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.constants.EstadoEmpleado;
import com.gestpro.gestpro.domain.dto.empleado.EmpleadoNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.IEmpleadoService;
import com.gestpro.gestpro.persistence.entity.Empleado;
import com.gestpro.gestpro.persistence.entity.Local;
import com.gestpro.gestpro.persistence.entity.Usuario;
import com.gestpro.gestpro.persistence.repository.EmpleadoRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private LocalService localService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Optional<Empleado> getById(String id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado saveEmpleado(EmpleadoNuevoDTO empleado) {
        return empleadoRepository.save(empleadoNuevoDTOToEmpleado(empleado));
    }

    @Override
    public Empleado update(EmpleadoNuevoDTO empleado) {
        return empleadoRepository.save(empleadoNuevoDTOToEmpleado(empleado));
    }

    @Override
    public Boolean delete(String id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private Empleado empleadoNuevoDTOToEmpleado(EmpleadoNuevoDTO empleadoNuevoDTO) {
        Empleado empleado = new Empleado();
        Optional<Local> local = localService.findLocalById(empleadoNuevoDTO.getLocal());
        Optional<Usuario> usuario = usuarioService.findByCedula(empleadoNuevoDTO.getUsuario());
        EstadoEmpleado estado = EstadoEmpleado.valueOf(empleadoNuevoDTO.getEstado());

        if (local.isPresent() && usuario.isPresent()) {
            empleado.setId(empleadoNuevoDTO.getId());
            empleado.setFechaContratado(empleadoNuevoDTO.getFechaContratado());
            empleado.setFechaDespedido(empleadoNuevoDTO.getFechaDespedido());
            empleado.setLocal(local.get());
            empleado.setUsuario(usuario.get());
            empleado.setEstado(estado);
        }

        return empleado;
    }

}
