package com.gestpro.gestpro.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.planes.PlanesNuevoDTO;
import com.gestpro.gestpro.domain.dto.planes.VigenciaPlanNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.planes.IPlanesService;
import com.gestpro.gestpro.domain.service.interfaces.planes.IVigenciaPlanService;
import com.gestpro.gestpro.persistence.entity.Empresa;
import com.gestpro.gestpro.persistence.entity.planes.Planes;
import com.gestpro.gestpro.persistence.entity.planes.VigenciaPlan;
import com.gestpro.gestpro.persistence.repository.planes.PlanesRepository;
import com.gestpro.gestpro.persistence.repository.planes.VigenciaPlanRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class PlanesService implements IPlanesService, IVigenciaPlanService {

    @Autowired
    private PlanesRepository planesRepository;

    @Autowired
    private VigenciaPlanRepository vigenciaPlanRepository;

    @Autowired
    private EmpresaService empresaService;

    // Planes

    @Override
    public List<Planes> getAllPlanes() {
        return planesRepository.findAll();
    }

    @Override
    public Optional<Planes> findPlanesById(Integer id) {
        return planesRepository.findById(id);
    }

    @Override
    public Planes createPlanes(PlanesNuevoDTO planes) {
        return planesRepository.save(convertPlanesNuevoDTOToPlanes(planes));
    }

    @Override
    public Planes updatePlanes(PlanesNuevoDTO planes) {
        return planesRepository.save(convertPlanesNuevoDTOToPlanes(planes));
    }

    @Override
    public Boolean deletePlanes(Integer id) {
        if (planesRepository.existsById(id)) {
            planesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Vigencia Plan

    @Override
    public VigenciaPlan createVigenciaPlan(VigenciaPlanNuevoDTO vigenciaPlan) {
        return vigenciaPlanRepository.save(convertVigenciaPlanNuevoDTOToVigenciaPlan(vigenciaPlan));
    }

    @Override
    public VigenciaPlan updateVigenciaPlan(VigenciaPlanNuevoDTO vigenciaPlan) {
        return vigenciaPlanRepository.save(convertVigenciaPlanNuevoDTOToVigenciaPlan(vigenciaPlan));
    }

    @Override
    public Boolean deleteVigenciaPlan(String id) {
        if (vigenciaPlanRepository.existsById(id)) {
            vigenciaPlanRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private Planes convertPlanesNuevoDTOToPlanes(PlanesNuevoDTO planes) {
        Planes plan = new Planes();
        plan.setNombre(planes.getNombre());
        plan.setPrecio(planes.getPrecio());
        plan.setDescripcion(planes.getDescripcion());
        return plan;
    }

    private VigenciaPlan convertVigenciaPlanNuevoDTOToVigenciaPlan(VigenciaPlanNuevoDTO vigenciaPlan) {
        VigenciaPlan vigencia = new VigenciaPlan();
        Optional<Planes> plan = findPlanesById(vigenciaPlan.getPlan());
        Optional<Empresa> empresa = empresaService.findByNIT(vigenciaPlan.getEmpresa());

        if (plan.isPresent() && empresa.isPresent()) {
            vigencia.setId(vigenciaPlan.getId());
            vigencia.setEmpresa(empresa.get());
            vigencia.setPlan(plan.get());
            vigencia.setFechaCompra(vigenciaPlan.getFechaCompra());
            vigencia.setFechaFinalizacion(vigenciaPlan.getFechaFinalizacion());
        }

        return vigencia;
    }

}
