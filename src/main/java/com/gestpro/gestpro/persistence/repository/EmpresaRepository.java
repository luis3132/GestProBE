package com.gestpro.gestpro.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestpro.gestpro.persistence.entity.Empresa;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
    
    @Query("SELECT e FROM Empresa e WHERE e.dueno = ?1")
    public List<Empresa> findByDueno(String dueno);

}
