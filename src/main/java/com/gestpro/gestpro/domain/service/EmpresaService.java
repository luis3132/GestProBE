package com.gestpro.gestpro.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.service.interfaces.IEmpresaService;
import com.gestpro.gestpro.persistence.entity.Empresa;
import com.gestpro.gestpro.persistence.repository.EmpresaRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class EmpresaService implements IEmpresaService{
    
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findByNIT(String nit) {
        return empresaRepository.findById(nit);
    }
    
    @Override
    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
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
