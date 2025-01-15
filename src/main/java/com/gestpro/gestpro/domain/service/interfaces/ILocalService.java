package com.gestpro.gestpro.domain.service.interfaces;

import java.util.Optional;

import com.gestpro.gestpro.domain.dto.local.LocalNuevoDTO;
import com.gestpro.gestpro.persistence.entity.Local;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ILocalService {
    public Optional<Local> findLocalById(String id);
    public Local createLocal(LocalNuevoDTO localNuevo);
    public Local updateLocal(LocalNuevoDTO localNuevo);
    public Boolean deleteLocal(String id);
}
