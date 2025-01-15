package com.gestpro.gestpro.domain.service.interfaces;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.gestpro.gestpro.domain.dto.usuario.UsuarioRegisterDTO;
import com.gestpro.gestpro.persistence.entity.Usuario;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface IUsuarioService {
    public Optional<Usuario> findbyUsername(String username);
    public UserDetails loadUserByUsername(String username);
    public Usuario createUsuario(UsuarioRegisterDTO usuario);
    public Usuario updateUsuario(Usuario usuario);
    public Boolean deleteUsuario(String cedula);
    public Optional<Usuario> findByCedula(String cedula);
}
