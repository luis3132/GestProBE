package com.gestpro.gestpro.persistence.entity.roles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gestpro.gestpro.persistence.entity.Empleado;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol_emp")
public class RolEmp {
    
    @EmbeddedId
    private RolEmpPK id;

    @ManyToOne
    @MapsId("empleado")
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @JsonBackReference("empleado-rol")
    private Empleado empleado;

    @ManyToOne
    @MapsId("rol")
    @JoinColumn(name = "rol", referencedColumnName = "id")
    private Roles rol;
}
