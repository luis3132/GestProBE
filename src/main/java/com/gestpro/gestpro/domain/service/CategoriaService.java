package com.gestpro.gestpro.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.categoria.ArtiCateNuevaDTO;
import com.gestpro.gestpro.domain.service.interfaces.categoria.IArtiCateService;
import com.gestpro.gestpro.domain.service.interfaces.categoria.ICategoriaService;
import com.gestpro.gestpro.persistence.entity.Articulo;
import com.gestpro.gestpro.persistence.entity.categoria.ArtiCate;
import com.gestpro.gestpro.persistence.entity.categoria.ArtiCatePK;
import com.gestpro.gestpro.persistence.entity.categoria.Categoria;
import com.gestpro.gestpro.persistence.repository.categoria.ArtiCateRepository;
import com.gestpro.gestpro.persistence.repository.categoria.CategoriaRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class CategoriaService implements ICategoriaService, IArtiCateService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ArtiCateRepository artiCateRepository;

    @Autowired
    private ArticuloService articuloService;

    // Categoria

    @Override
    public Optional<Categoria> findCategoriaById(String id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Boolean deleteCategoria(String id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Articulo Categoria

    @Override
    public List<ArtiCate> createArtiCate(List<ArtiCateNuevaDTO> artiCateNueva) {
        List<ArtiCate> artiCateList = artiCateRepository.saveAll(artiCateNueva.stream().map(this::convertArtiCateNuevaDTOToArtiCate).toList());
        return artiCateList;
    }

    @Override
    public Boolean deleteArtiCate(ArtiCatePK id) {
        if (artiCateRepository.existsById(id)) {
            artiCateRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private ArtiCate convertArtiCateNuevaDTOToArtiCate(ArtiCateNuevaDTO artiCateNueva) {
        ArtiCate artiCate = new ArtiCate();
        ArtiCatePK id = new ArtiCatePK();

        id.setCategoria(artiCateNueva.getCategoria());
        id.setArticulo(artiCateNueva.getArticulo());

        Optional<Categoria> categoria = findCategoriaById(artiCateNueva.getCategoria());
        Optional<Articulo> articulo = articuloService.findArticuloById(artiCateNueva.getArticulo());

        if (categoria.isPresent() && articulo.isPresent()) {
            artiCate.setCategoria(categoria.get());
            artiCate.setArticulo(articulo.get());
            artiCate.setId(id);
        }

        return artiCate;
    }

}
