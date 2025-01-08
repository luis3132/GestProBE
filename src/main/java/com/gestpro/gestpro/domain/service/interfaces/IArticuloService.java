package com.gestpro.gestpro.domain.service.interfaces;

import java.util.Optional;

import com.gestpro.gestpro.domain.dto.articulo.ArticuloNuevoDTO;
import com.gestpro.gestpro.persistence.entity.Articulo;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface IArticuloService {
    public Optional<Articulo> findArticuloById(String id);
    public Articulo createArticulo(ArticuloNuevoDTO articuloNuevo);
    public Articulo updateArticulo(ArticuloNuevoDTO articuloNuevo);
    public Boolean deleteArticulo(String id);
}
