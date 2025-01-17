package com.gestpro.gestpro.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.constants.EstadoUsuario;
import com.gestpro.gestpro.domain.dto.usuario.UsuarioRegisterDTO;
import com.gestpro.gestpro.domain.service.interfaces.IUsuarioService;
import com.gestpro.gestpro.persistence.entity.Empleado;
import com.gestpro.gestpro.persistence.entity.Usuario;
import com.gestpro.gestpro.persistence.entity.roles.RolEmp;
import com.gestpro.gestpro.persistence.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Lazy
    private RolesService rolesService;

    @Override
    public Optional<Usuario> findbyUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = findbyUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        // Roles de usuario
        List<GrantedAuthority> authority;

        if (usuario.getRoles() != null) {
            authority = usuario.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRoles().getRoles()))
                    .collect(Collectors.toList());
        } else {
            authority = List.of(new SimpleGrantedAuthority("USER"));
        }

        // Roles de empleado
        if (usuario.getEmpleos() != null) {
            List<Empleado> empleados = usuario.getEmpleos();
            List<RolEmp> roles = empleados.stream().map(Empleado::getRoles).flatMap(List::stream)
                    .collect(Collectors.toList());

            List<GrantedAuthority> authorityRoles = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRol().getRoles())).collect(Collectors.toList());

            authority.addAll(authorityRoles);
        }

        Set<GrantedAuthority> grantedAuthorities = Set.copyOf(authority);

        return new User(usuario.getNombreUsuario(), usuario.getContrasena(), grantedAuthorities);
    }

    @Override
    public Usuario createUsuario(UsuarioRegisterDTO usuario) {
        if (usuarioRepository.existsById(usuario.getCedula()) || findbyUsername(usuario.getNombreUsuario()).isPresent()) {
            return null;
        } else {
            usuarioRepository.save(toUsuario(usuario));
            usuario.getRoles().forEach(rol -> {
                rol.setUsuario(usuario.getCedula());
            });
            rolesService.guardarRolUsr(usuario.getRoles());
        }

        return findByCedula(usuario.getCedula()).get();
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

    // Converters

    private Usuario toUsuario(UsuarioRegisterDTO usuario) {
        Usuario usuarioEntity = new Usuario();
        EstadoUsuario estado = EstadoUsuario.valueOf(usuario.getEstado());
        Date hoy = new Date(System.currentTimeMillis());

        usuarioEntity.setCedula(usuario.getCedula());
        usuarioEntity.setNombres(usuario.getNombres());
        usuarioEntity.setApellidos(usuario.getApellidos());
        usuarioEntity.setNombreUsuario(usuario.getNombreUsuario());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setContrasena(usuario.getContrasena());
        usuarioEntity.setDireccion(usuario.getDireccion());
        usuarioEntity.setFechaCreacion(hoy);
        usuarioEntity.setTelefono(usuario.getTelefono());
        usuarioEntity.setEstado(estado);
        return usuarioEntity;
    }
}
