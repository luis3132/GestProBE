package com.gestpro.gestpro.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestpro.gestpro.constants.EstadoEmpresa;
import com.gestpro.gestpro.persistence.entity.planes.VigenciaPlan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empresa")
public class Empresa {
    
    @Id
    private String nit;
    private String nombre;
    private String dueno;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String departamento;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEmpresa estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    @JsonManagedReference("empresa-local")
    @JsonIgnoreProperties("empresa")
    private List<Local> locales;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    @JsonManagedReference("empresa-articulo")
    @JsonIgnoreProperties("empresa")
    private List<Articulo> articulos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    @JsonManagedReference("empresa-plan")
    @JsonIgnoreProperties("empresa")
    private List<VigenciaPlan> vigenciasPlan;

}
