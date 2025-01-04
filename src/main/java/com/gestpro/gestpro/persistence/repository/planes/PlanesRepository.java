package com.gestpro.gestpro.persistence.repository.planes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.planes.Planes;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface PlanesRepository extends JpaRepository<Planes, Integer> {
    
}
