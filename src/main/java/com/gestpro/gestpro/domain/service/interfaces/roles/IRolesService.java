package com.gestpro.gestpro.domain.service.interfaces.roles;

import com.gestpro.gestpro.domain.dto.roles.RolesNuevoDTO;
import com.gestpro.gestpro.persistence.entity.roles.Roles;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IRolesService {
    public Roles guardarRol(RolesNuevoDTO rol);
}
