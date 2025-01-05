package com.gestpro.gestpro.domain.service.interfaces.roles;

import com.gestpro.gestpro.domain.dto.roles.RolUsrNuevoDTO;
import com.gestpro.gestpro.persistence.entity.roles.RolUsr;
import com.gestpro.gestpro.persistence.entity.roles.RolUsrPK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IRolUsrService {
    public RolUsr guardarRolUsr(RolUsrNuevoDTO rolUsr);
    public Boolean eliminarRolUsr(RolUsrPK rolUsr);
}
