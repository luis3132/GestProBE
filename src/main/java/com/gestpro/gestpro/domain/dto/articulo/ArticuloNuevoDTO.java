package com.gestpro.gestpro.domain.dto.articulo;

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
public class ArticuloNuevoDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private Integer impuesto;
    private Integer puntoReorden;
    private String empresa;
    private String caracteristicaDimensional;
    private String estado;
}
