package com.gestpro.gestpro.persistence.repository.venta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.venta.VentUnid;
import com.gestpro.gestpro.persistence.entity.venta.VentUnidPK;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface VentUnidRepository extends JpaRepository<VentUnid, VentUnidPK> {
    
}
