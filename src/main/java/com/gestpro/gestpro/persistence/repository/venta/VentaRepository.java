package com.gestpro.gestpro.persistence.repository.venta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.venta.Venta;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface VentaRepository extends JpaRepository<Venta, String> {
    
}
