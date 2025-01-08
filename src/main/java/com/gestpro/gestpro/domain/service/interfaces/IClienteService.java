package com.gestpro.gestpro.domain.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.gestpro.gestpro.domain.dto.cliente.ClienteNuevoDTO;
import com.gestpro.gestpro.persistence.entity.cliente.Cliente;
import com.gestpro.gestpro.persistence.entity.cliente.ClientePK;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface IClienteService {
    public List<Cliente> findAll(String empresa);
    public Optional<Cliente> findById(ClientePK id);
    public Cliente save(ClienteNuevoDTO cliente);
    public Cliente update(ClienteNuevoDTO cliente);
    public Boolean delete(ClientePK id);
}
