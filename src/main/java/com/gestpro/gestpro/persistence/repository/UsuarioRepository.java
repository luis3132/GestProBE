package com.gestpro.gestpro.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestpro.gestpro.persistence.entity.Usuario;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario = ?1")
    public Optional<Usuario> findByUsername(String nombreUsuario);

}
