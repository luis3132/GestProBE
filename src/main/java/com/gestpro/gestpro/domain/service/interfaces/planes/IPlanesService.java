package com.gestpro.gestpro.domain.service.interfaces.planes;

import java.util.List;
import java.util.Optional;

import com.gestpro.gestpro.domain.dto.planes.PlanesNuevoDTO;
import com.gestpro.gestpro.persistence.entity.planes.Planes;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IPlanesService {
    public List<Planes> getAllPlanes();
    public Optional<Planes> findPlanesById(Integer id);
    public Planes createPlanes(PlanesNuevoDTO planes);
    public Planes updatePlanes(PlanesNuevoDTO planes);
    public Boolean deletePlanes(Integer id);
}
