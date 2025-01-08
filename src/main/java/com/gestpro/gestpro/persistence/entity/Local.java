package com.gestpro.gestpro.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "local")
public class Local {
    
    @Id
    private String id;

    private String nombre;
    private String direccion;
    private String telefono;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_padre", referencedColumnName = "nit")
    @JsonBackReference("empresa-local")
    @JsonIgnoreProperties("locales")
    private Empresa empresaPadre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    @JsonManagedReference("local-empleado")
    @JsonIgnoreProperties("local")
    private List<Empleado> empleados;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    @JsonManagedReference("local-unidad")
    private List<Unidad> unidades;

}
