package com.gestpro.gestpro.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.unidad.UnidadNuevaDTO;
import com.gestpro.gestpro.domain.service.interfaces.IUnidadService;
import com.gestpro.gestpro.persistence.entity.Articulo;
import com.gestpro.gestpro.persistence.entity.Local;
import com.gestpro.gestpro.persistence.entity.Unidad;
import com.gestpro.gestpro.persistence.repository.UnidadRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class UnidadService implements IUnidadService {
    
    @Autowired
    private UnidadRepository unidadRepository;

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private LocalService localService;

    @Override
    public Unidad createUnidad(UnidadNuevaDTO unidadNueva) {
        return unidadRepository.save(convertUnidad(unidadNueva));
    }

    @Override
    public Unidad updateUnidad(UnidadNuevaDTO unidadNueva) {
        return unidadRepository.save(convertUnidad(unidadNueva));
    }

    @Override
    public Boolean deleteUnidad(String id) {
        if (unidadRepository.existsById(id)) {
            unidadRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private Unidad convertUnidad(UnidadNuevaDTO unidadNueva) {
        Unidad unidad = new Unidad();
        Optional<Articulo> articulo = articuloService.findArticuloById(unidadNueva.getArticulo());
        Optional<Local> local = localService.findLocalById(unidadNueva.getLocal());
        
        if (articulo.isPresent() && local.isPresent()) {
            unidad.setArticulo(articulo.get());
            unidad.setLocal(local.get());

            
            unidad.setSku(unidadNueva.getSku());
            unidad.setNombre(unidadNueva.getNombre());
            unidad.setDescripcion(unidadNueva.getDescripcion());
            unidad.setPrecioDetal(unidadNueva.getPrecioDetal());
            unidad.setPrecioMayorista(unidadNueva.getPrecioMayorista());
            unidad.setFechaCreacion(unidadNueva.getFechaCreacion());
            unidad.setFechaCompra(unidadNueva.getFechaCompra());
        }
        return unidad;
    }
}
