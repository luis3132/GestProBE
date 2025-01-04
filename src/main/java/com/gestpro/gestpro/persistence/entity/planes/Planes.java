package com.gestpro.gestpro.persistence.entity.planes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "planes")
public class Planes {
    
    @Id
    private Integer id;
    private String nombre;
    private Integer precio;
    private String descripcion;
    
}
