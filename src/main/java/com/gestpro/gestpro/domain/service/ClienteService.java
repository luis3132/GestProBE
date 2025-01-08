package com.gestpro.gestpro.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.constants.EstadoCliente;
import com.gestpro.gestpro.domain.dto.cliente.ClienteNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.IClienteService;
import com.gestpro.gestpro.persistence.entity.cliente.Cliente;
import com.gestpro.gestpro.persistence.entity.cliente.ClientePK;
import com.gestpro.gestpro.persistence.repository.ClienteRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll(String empresa) {
        return clienteRepository.findAllByEmpresa(empresa);
    }

    @Override
    public Optional<Cliente> findById(ClientePK id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(ClienteNuevoDTO cliente) {
        return clienteRepository.save(convertDTOToCliente(cliente));
    }

    @Override
    public Cliente update(ClienteNuevoDTO cliente) {
        return clienteRepository.save(convertDTOToCliente(cliente));
    }

    @Override
    public Boolean delete(ClientePK id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private Cliente convertDTOToCliente(ClienteNuevoDTO cliente) {
        Cliente c = new Cliente();
        EstadoCliente estado = EstadoCliente.valueOf(cliente.getEstado());

        c.setCedula(cliente.getCedula());
        c.setEmpresa(cliente.getEmpresa());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setTelefono(cliente.getTelefono());
        c.setFijo(cliente.getFijo());
        c.setDescripcion(cliente.getDescripcion());
        c.setMayorista(cliente.getMayorista());
        c.setFechaCreacion(cliente.getFechaCreacion());
        c.setEstado(estado);
        c.setEmail(cliente.getEmail());

        return c;
    }

}
