package com.gestpro.gestpro.domain.dto.roles;

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
public class RolUsrNuevoDTO {
    private String usuario;
    private Integer roles;
}
