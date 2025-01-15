package com.gestpro.gestpro.domain.dto.planes;

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
public class PlanesNuevoDTO {
    private String nombre;
    private Integer precio;
    private String descripcion;
}
