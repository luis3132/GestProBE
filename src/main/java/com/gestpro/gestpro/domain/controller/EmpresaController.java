package com.gestpro.gestpro.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestpro.gestpro.domain.dto.empresa.EmpresaNuevaDTO;
import com.gestpro.gestpro.domain.service.EmpresaService;
import com.gestpro.gestpro.persistence.entity.Empresa;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/api/empresa")
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/nueva")
    public ResponseEntity<Empresa> create(@RequestBody EmpresaNuevaDTO empresaNuevaDTO) {
        Empresa empresa = empresaService.createEmpresa(empresaNuevaDTO);

        if (empresa == null) {
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(empresaService.createEmpresa(empresaNuevaDTO));
    }
    

}
