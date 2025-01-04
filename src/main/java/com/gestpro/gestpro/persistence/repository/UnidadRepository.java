package com.gestpro.gestpro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.Unidad;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface UnidadRepository extends JpaRepository<Unidad, String> {
    
}
