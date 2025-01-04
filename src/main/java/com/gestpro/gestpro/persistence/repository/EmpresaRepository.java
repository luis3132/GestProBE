package com.gestpro.gestpro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.Empresa;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
    
}
