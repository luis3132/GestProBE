package com.gestpro.gestpro.persistence.entity.roles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gestpro.gestpro.persistence.entity.Usuario;

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
@Table(name = "rol_usr")
public class RolUsr {
    
    @EmbeddedId
    private RolUsrPK id;

    @ManyToOne
    @MapsId("usuario")
    @JoinColumn(name = "usuario", referencedColumnName = "cedula")
    @JsonBackReference("usuario-rol")
    private Usuario usuario;

    @ManyToOne
    @MapsId("rol")
    @JoinColumn(name = "roles", referencedColumnName = "id")
    private Roles rol;
}
