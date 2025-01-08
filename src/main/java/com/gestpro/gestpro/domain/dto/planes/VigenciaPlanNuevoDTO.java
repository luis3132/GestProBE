package com.gestpro.gestpro.domain.dto.planes;

import java.sql.Date;

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
public class VigenciaPlanNuevoDTO {
    private String id;
    private String empresa;
    private Integer plan;
    private Date fechaCompra;
    private Date fechaFinalizacion;
}
