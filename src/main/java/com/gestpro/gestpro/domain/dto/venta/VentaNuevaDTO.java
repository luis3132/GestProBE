package com.gestpro.gestpro.domain.dto.venta;

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
public class VentaNuevaDTO {
    private String id;
    private Date fechaVenta;
    private String cliente;
    private String empresa;
    private String pagacon;
    private String cambio;
    private String usuario;
    private String metodoPago;
}
