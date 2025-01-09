package com.gestpro.gestpro.domain.dto.usuario;

import java.util.List;

import com.gestpro.gestpro.domain.dto.roles.RolUsrNuevoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRegisterDTO {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String email;
    private String contrasena;
    private String direccion;
    private String telefono;
    private String estado;
    private List<RolUsrNuevoDTO> roles;
}
