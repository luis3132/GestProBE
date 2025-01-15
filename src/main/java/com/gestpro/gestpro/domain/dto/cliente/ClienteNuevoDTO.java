package com.gestpro.gestpro.domain.dto.cliente;

import java.util.Date;

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
public class ClienteNuevoDTO {
    private String cedula;
    private String empresa;
    private String nombre;
    private String apellido;
    private String telefono;
    private String fijo;
    private String descripcion;
    private Boolean mayorista;
    private Date fechaCreacion;
    private String estado;
    private String email;
}
