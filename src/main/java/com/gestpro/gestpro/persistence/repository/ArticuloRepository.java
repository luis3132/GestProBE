package com.gestpro.gestpro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.Articulo;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ArticuloRepository extends JpaRepository<Articulo, String> {
    
}
