package com.gestpro.gestpro.persistence.entity.roles;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolUstPK {
    private String usuario;
    private Integer rol;
}
