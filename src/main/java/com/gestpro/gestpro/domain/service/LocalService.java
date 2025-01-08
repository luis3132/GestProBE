package com.gestpro.gestpro.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.local.LocalNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.ILocalService;
import com.gestpro.gestpro.persistence.entity.Empresa;
import com.gestpro.gestpro.persistence.entity.Local;
import com.gestpro.gestpro.persistence.repository.LocalRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class LocalService implements ILocalService {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private EmpresaService empresaService;

    @Override
    public Optional<Local> findLocalById(String id) {
        return localRepository.findById(id);
    }

    @Override
    public Local createLocal(LocalNuevoDTO localNuevo) {
        return localRepository.save(convertDTOToEntity(localNuevo));
    }

    @Override
    public Local updateLocal(LocalNuevoDTO localNuevo) {
        return localRepository.save(convertDTOToEntity(localNuevo));
    }

    @Override
    public Boolean deleteLocal(String id) {
        if (localRepository.existsById(id)) {
            localRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private Local convertDTOToEntity(LocalNuevoDTO localNuevo) {
        Local local = new Local();
        Optional<Empresa> empresa = empresaService.findByNIT(localNuevo.getEmpresaPadre());

        if (empresa.isPresent()) {
            local.setNombre(localNuevo.getNombre());
            local.setDireccion(localNuevo.getDireccion());
            local.setTelefono(localNuevo.getTelefono());
            local.setEmpresaPadre(empresa.get());
        }

        return local;
    }

}
