package com.gestpro.gestpro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.Local;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface LocalRepository extends JpaRepository<Local, String> {
    
}
