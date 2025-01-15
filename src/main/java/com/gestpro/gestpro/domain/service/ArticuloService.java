package com.gestpro.gestpro.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.constants.articulo.CaracteristicaDimensional;
import com.gestpro.gestpro.constants.articulo.EstadoArticulo;
import com.gestpro.gestpro.domain.dto.articulo.ArticuloNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.IArticuloService;
import com.gestpro.gestpro.persistence.entity.Articulo;
import com.gestpro.gestpro.persistence.entity.Empresa;
import com.gestpro.gestpro.persistence.repository.ArticuloRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class ArticuloService implements IArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private EmpresaService empresaService;

    @Override
    public Optional<Articulo> findArticuloById(String id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo createArticulo(ArticuloNuevoDTO articuloNuevo) {
        return articuloRepository.save(convertArticuloNuevoDTOToArticulo(articuloNuevo));
    }

    @Override
    public Articulo updateArticulo(ArticuloNuevoDTO articuloNuevo) {
        return articuloRepository.save(convertArticuloNuevoDTOToArticulo(articuloNuevo));
    }

    @Override
    public Boolean deleteArticulo(String id) {
        if (articuloRepository.existsById(id)) {
            articuloRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private Articulo convertArticuloNuevoDTOToArticulo(ArticuloNuevoDTO articuloNuevo) {
        Articulo articulo = new Articulo();
        Optional<Empresa> empresa = empresaService.findByNIT(articuloNuevo.getEmpresa());

        CaracteristicaDimensional caracteristicaDimensional = CaracteristicaDimensional.valueOf(articuloNuevo.getCaracteristicaDimensional());

        EstadoArticulo estado = EstadoArticulo.valueOf(articuloNuevo.getEstado());

        if (empresa.isPresent()) {
            articulo.setId(articuloNuevo.getId());
            articulo.setNombre(articuloNuevo.getNombre());
            articulo.setDescripcion(articuloNuevo.getDescripcion());
            articulo.setImpuesto(articuloNuevo.getImpuesto());
            articulo.setPuntoReorden(articuloNuevo.getPuntoReorden());
            articulo.setEmpresa(empresa.get());
            articulo.setCaracteristicaDimensional(caracteristicaDimensional);
            articulo.setEstado(estado);
        }

        return articulo;
    }

}
