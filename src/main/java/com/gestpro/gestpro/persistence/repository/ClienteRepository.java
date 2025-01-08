package com.gestpro.gestpro.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestpro.gestpro.persistence.entity.cliente.Cliente;
import com.gestpro.gestpro.persistence.entity.cliente.ClientePK;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

public interface ClienteRepository extends JpaRepository<Cliente, ClientePK> {
    @Query("SELECT c FROM Cliente c WHERE c.empresa = ?1")
    public List<Cliente> findAllByEmpresa(String empresa);
}
