package com.gestpro.gestpro.domain.service.interfaces.categoria;

import java.util.Optional;

import com.gestpro.gestpro.persistence.entity.categoria.Categoria;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ICategoriaService {
    public Optional<Categoria> findCategoriaById(String id);
    public Categoria createCategoria(Categoria categoria);
    public Boolean deleteCategoria(String id);
}
