package com.gestpro.gestpro.persistence.entity.cliente;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestpro.gestpro.constants.EstadoCliente;
import com.gestpro.gestpro.persistence.entity.venta.Venta;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {
    
    @EmbeddedId
    private ClientePK id;

    @MapsId("cedula")
    private String cedula;

    @MapsId("empresa")
    private String empresa;

    private String nombre;
    private String apellido;
    private String telefono;
    private String fijo;
    private String descripcion;
    private Boolean mayorista;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoCliente estado;

    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference("cliente-venta")
    @JsonIgnoreProperties("cliente")
    private List<Venta> ventas;

}
