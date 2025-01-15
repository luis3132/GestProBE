package com.gestpro.gestpro.persistence.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "unidad")
public class Unidad {
    
    @Id
    private String sku;

    private String nombre;
    private String descripcion;

    @Column(name = "precio_detal")
    private Long precioDetal;

    @Column(name = "precio_mayorista")
    private Long precioMayorista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articulo", referencedColumnName = "id")
    @JsonIgnoreProperties("empresa")
    private Articulo articulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local", referencedColumnName = "id")
    @JsonBackReference("local-unidad")
    @JsonIgnoreProperties(value = {"empleados", "articulos"})
    private Local local;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_compra")
    private Date fechaCompra;
}
