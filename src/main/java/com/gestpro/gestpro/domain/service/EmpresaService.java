package com.gestpro.gestpro.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.empresa.EmpresaNuevaDTO;
import com.gestpro.gestpro.domain.dto.local.LocalNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.IEmpresaService;
import com.gestpro.gestpro.persistence.entity.Empresa;
import com.gestpro.gestpro.persistence.repository.EmpresaRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class EmpresaService implements IEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    @Lazy
    private LocalService localService;

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findByNIT(String nit) {
        return empresaRepository.findById(nit);
    }

    @Override
    public Empresa createEmpresa(EmpresaNuevaDTO empresa) {
        if (findByNIT(empresa.getEmpresa().getNit()).isPresent()) {
            return null;
        } else {
            Empresa empresaNueva = empresaRepository.save(empresa.getEmpresa());

            LocalNuevoDTO localNuevoDTO = empresa.getLocalNuevoDTO();
            localNuevoDTO.setEmpresaPadre(empresa.getEmpresa().getNit());
            localNuevoDTO.setDireccion(empresa.getEmpresa().getDireccion());
            localNuevoDTO.setTelefono(empresa.getEmpresa().getTelefono());
            localNuevoDTO.setId(UUID.randomUUID().toString());
            localNuevoDTO.setEstado(empresa.getEmpresa().getEstado().toString());
            localNuevoDTO.setCiudad(empresa.getEmpresa().getCiudad());

            localService.createLocal(localNuevoDTO);

            return empresaNueva;
        }
    }

    @Override
    public Empresa updateEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Boolean deleteEmpresa(String nit) {
        if (empresaRepository.existsById(nit)) {
            empresaRepository.deleteById(nit);
            return true;
        }
        return false;
    }

}
