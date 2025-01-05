package com.gestpro.gestpro.domain.service.interfaces;

import java.util.Optional;

import com.gestpro.gestpro.persistence.entity.Usuario;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface IUsuarioService {
    public Usuario createUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario);
    public Boolean deleteUsuario(String cedula);
    public Optional<Usuario> findByCedula(String cedula);
}
