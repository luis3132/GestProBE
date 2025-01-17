package com.gestpro.gestpro.domain.dto.empresa;

import com.gestpro.gestpro.domain.dto.local.LocalNuevoDTO;
import com.gestpro.gestpro.persistence.entity.Empresa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaNuevaDTO {
    private Empresa empresa;
    private LocalNuevoDTO localNuevoDTO;
}
