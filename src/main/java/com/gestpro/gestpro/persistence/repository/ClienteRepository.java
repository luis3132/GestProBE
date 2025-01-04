package com.gestpro.gestpro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestpro.gestpro.persistence.entity.cliente.Cliente;
import com.gestpro.gestpro.persistence.entity.cliente.ClientePK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ClienteRepository extends JpaRepository<Cliente, ClientePK> {
    
}
