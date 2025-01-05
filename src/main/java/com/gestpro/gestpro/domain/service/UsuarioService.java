package com.gestpro.gestpro.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.service.interfaces.IUsuarioService;
import com.gestpro.gestpro.persistence.entity.Usuario;
import com.gestpro.gestpro.persistence.repository.UsuarioRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findByCedula(String cedula) {
        return usuarioRepository.findById(cedula);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Boolean deleteUsuario(String cedula) {
        if (usuarioRepository.existsById(cedula)) {
            usuarioRepository.deleteById(cedula);
            return true;
        }
        return false;
    }
}
