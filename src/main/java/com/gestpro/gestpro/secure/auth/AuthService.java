package com.gestpro.gestpro.secure.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.usuario.UsuarioLoginDTO;
import com.gestpro.gestpro.domain.dto.usuario.UsuarioRegisterDTO;
import com.gestpro.gestpro.domain.service.UsuarioService;
import com.gestpro.gestpro.persistence.entity.Usuario;
import com.gestpro.gestpro.secure.jwt.JwtService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(UsuarioLoginDTO usuarioLoginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioLoginDTO.getNombreUsuario(),
                usuarioLoginDTO.getContrasena()));
        UserDetails userDetails = usuarioService.loadUserByUsername(usuarioLoginDTO.getNombreUsuario());

        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(UsuarioRegisterDTO usuarioLoginDTO) {
        usuarioLoginDTO.setContrasena(passwordEncoder.encode(usuarioLoginDTO.getContrasena()));
        Usuario usuario = usuarioService.createUsuario(usuarioLoginDTO);

        UserDetails userDetails = usuarioService.loadUserByUsername(usuario.getNombreUsuario());

        return AuthResponse.builder()
                .token(jwtService.getToken(userDetails))
                .build();
    }

}
