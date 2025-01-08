package com.gestpro.gestpro.domain.service.interfaces.venta;

import com.gestpro.gestpro.domain.dto.venta.VentUnidNuevoDTO;
import com.gestpro.gestpro.persistence.entity.venta.VentUnid;
import com.gestpro.gestpro.persistence.entity.venta.VentUnidPK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IVentUnidService {
    public VentUnid createVentUnid(VentUnidNuevoDTO ventUnid);
    public Boolean deleteVentUnid(VentUnidPK id);
}
