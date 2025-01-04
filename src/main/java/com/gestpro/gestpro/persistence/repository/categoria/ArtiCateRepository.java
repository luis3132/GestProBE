package com.gestpro.gestpro.persistence.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.categoria.ArtiCate;
import com.gestpro.gestpro.persistence.entity.categoria.ArtiCatePK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ArtiCateRepository extends JpaRepository<ArtiCate, ArtiCatePK> {
    
}
