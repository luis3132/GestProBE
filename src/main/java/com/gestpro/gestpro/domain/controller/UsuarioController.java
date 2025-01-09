package com.gestpro.gestpro.domain.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestpro.gestpro.domain.service.UsuarioService;
import com.gestpro.gestpro.persistence.entity.Usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list/{username}")
    public ResponseEntity<Usuario> listByUsernameUsuario(@PathVariable("username") String nombreUsuarioString) {
        Optional<Usuario> usuario = usuarioService.findbyUsername(nombreUsuarioString);
        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.findbyUsername(nombreUsuarioString).get());
    }
    
    
}
