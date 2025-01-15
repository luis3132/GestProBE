package com.gestpro.gestpro.persistence.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.categoria.Categoria;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
    
}
