package com.gestpro.gestpro.domain.dto.local;

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
public class LocalNuevoDTO {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String empresaPadre;
}
