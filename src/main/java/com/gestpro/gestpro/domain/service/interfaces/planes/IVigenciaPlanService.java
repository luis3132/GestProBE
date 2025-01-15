package com.gestpro.gestpro.domain.service.interfaces.planes;

import com.gestpro.gestpro.domain.dto.planes.VigenciaPlanNuevoDTO;
import com.gestpro.gestpro.persistence.entity.planes.VigenciaPlan;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IVigenciaPlanService {
    public VigenciaPlan createVigenciaPlan(VigenciaPlanNuevoDTO vigenciaPlan);
    public VigenciaPlan updateVigenciaPlan(VigenciaPlanNuevoDTO vigenciaPlan);
    public Boolean deleteVigenciaPlan(String id);
}
