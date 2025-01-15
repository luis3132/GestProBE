package com.gestpro.gestpro.persistence.repository.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.roles.RolUsr;
import com.gestpro.gestpro.persistence.entity.roles.RolUsrPK;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface RolUsrRepository extends JpaRepository<RolUsr, RolUsrPK> {
    
}
