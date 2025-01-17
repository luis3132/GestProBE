package com.gestpro.gestpro.domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.gestpro.gestpro.domain.dto.empresa.EmpresaNuevaDTO;
import com.gestpro.gestpro.persistence.entity.Empresa;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface IEmpresaService {
    public List<Empresa> findAll();
    public Optional<Empresa> findByNIT(String nit);
    public Empresa createEmpresa(EmpresaNuevaDTO empresa);
    public Empresa updateEmpresa(Empresa empresa);
    public Boolean deleteEmpresa(String nit);
}
