package com.gestpro.gestpro.persistence.repository.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.roles.Roles;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    
}