package com.gestpro.gestpro.domain.service.interfaces.categoria;

import java.util.List;

import com.gestpro.gestpro.domain.dto.categoria.ArtiCateNuevaDTO;
import com.gestpro.gestpro.persistence.entity.categoria.ArtiCate;
import com.gestpro.gestpro.persistence.entity.categoria.ArtiCatePK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IArtiCateService {
    public List<ArtiCate> createArtiCate(List<ArtiCateNuevaDTO> artiCateNueva);
    public Boolean deleteArtiCate(ArtiCatePK id); 
}
