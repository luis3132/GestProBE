package com.gestpro.gestpro.persistence.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestpro.gestpro.constants.EstadoUsuario;
import com.gestpro.gestpro.persistence.entity.roles.RolUsr;

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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    private String cedula;
    private String nombres;
    private String apellidos;

    @Column(name = "nombre_usuario", unique = true)
    private String nombreUsuario;

    private String email;
    private String contrasena;
    private String direccion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoUsuario estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonManagedReference("usuario-rol")
    private List<RolUsr> roles;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario")
    @JsonManagedReference("usuario-empleado")
    @JsonIgnoreProperties("usuario")
    private List<Empleado> empleos;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "dueno")
    private List<Empresa> empresas;

}
