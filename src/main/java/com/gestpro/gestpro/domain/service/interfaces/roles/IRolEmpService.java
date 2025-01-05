package com.gestpro.gestpro.domain.service.interfaces.roles;

import com.gestpro.gestpro.domain.dto.roles.RolEmpNuevoDTO;
import com.gestpro.gestpro.persistence.entity.roles.RolEmp;
import com.gestpro.gestpro.persistence.entity.roles.RolEmpPK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IRolEmpService {
    public RolEmp guardarRolEmp(RolEmpNuevoDTO rolEmp);
    public Boolean eliminarRolEmp(RolEmpPK rolEmp);
}
