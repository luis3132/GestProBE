package com.gestpro.gestpro.domain.dto.unidad;

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
public class UnidadNuevaDTO {
    private String sku;
    private String nombre;
    private String descripcion;
    private Long precioDetal;
    private Long precioMayorista;
    private String articulo;
    private String local;
    private Date fechaCreacion;
    private Date fechaCompra;
}
