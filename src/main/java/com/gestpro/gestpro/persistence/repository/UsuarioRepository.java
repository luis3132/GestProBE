package com.gestpro.gestpro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.Usuario;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
}
