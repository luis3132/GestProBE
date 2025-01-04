package com.gestpro.gestpro.persistence.repository.planes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.planes.VigenciaPlan;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface VigenciaPlanRepository extends JpaRepository<VigenciaPlan, String> {
    
}
