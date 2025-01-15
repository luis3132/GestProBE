package com.gestpro.gestpro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.Empleado;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    
}
