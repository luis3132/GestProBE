package com.gestpro.gestpro.domain.dto.empleado;

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
public class EmpleadoNuevoDTO {
    private String id;
    private String usuario;
    private String local;
    private Date fechaContratado;
    private Date fechaDespedido;
    private String estado;
}
