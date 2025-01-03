package com.gestpro.gestpro.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestpro.gestpro.constants.EstadoEmpleado;
import com.gestpro.gestpro.persistence.entity.roles.RolEmp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "empleado")
public class Empleado {
    
    @Id
    private String id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario", referencedColumnName = "cedula")
    @JsonBackReference("usuario-empleado")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "local", referencedColumnName = "id")
    @JsonBackReference("local-empleado")
    private Local local;

    @Enumerated(EnumType.STRING)
    private EstadoEmpleado estado;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "empleado")
    @JsonManagedReference("empleado-rol")
    private List<RolEmp> roles;

}
