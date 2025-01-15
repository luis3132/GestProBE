package com.gestpro.gestpro.persistence.repository.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.roles.RolEmp;
import com.gestpro.gestpro.persistence.entity.roles.RolEmpPK;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface RolEmpRepository extends JpaRepository<RolEmp, RolEmpPK> {
    
}
