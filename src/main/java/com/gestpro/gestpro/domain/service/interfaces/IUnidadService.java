package com.gestpro.gestpro.domain.service.interfaces;

import com.gestpro.gestpro.domain.dto.unidad.UnidadNuevaDTO;
import com.gestpro.gestpro.persistence.entity.Unidad;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IUnidadService {   
    public Unidad createUnidad(UnidadNuevaDTO unidadNueva);
    public Unidad updateUnidad(UnidadNuevaDTO unidadNueva);
    public Boolean deleteUnidad(String id);
}
