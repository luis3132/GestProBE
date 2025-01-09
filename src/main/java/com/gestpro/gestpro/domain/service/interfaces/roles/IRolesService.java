package com.gestpro.gestpro.domain.service.interfaces.roles;

import java.util.Optional;

import com.gestpro.gestpro.domain.dto.roles.RolesNuevoDTO;
import com.gestpro.gestpro.persistence.entity.roles.Roles;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IRolesService {
    public Optional<Roles> findById(Integer id);
    public Roles guardarRol(RolesNuevoDTO rol);
}
