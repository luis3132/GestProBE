package com.gestpro.gestpro.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestpro.gestpro.constants.articulo.CaracteristicaDimensional;
import com.gestpro.gestpro.constants.articulo.EstadoArticulo;
import com.gestpro.gestpro.persistence.entity.categoria.ArtiCate;

import jakarta.persistence.Column;
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
 * @autor Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "articulo")
public class Articulo {
    
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Integer impuesto;

    @Column(name = "punto_reorden")
    private Integer puntoReorden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa", referencedColumnName = "nit")
    @JsonIgnoreProperties("locales")
    @JsonBackReference("empresa-articulo")
    private Empresa empresa;

    @Column(name = "caracteristica_dimensional")
    @Enumerated(EnumType.STRING)
    private CaracteristicaDimensional caracteristicaDimensional;

    @Enumerated(EnumType.STRING)
    private EstadoArticulo estado;

    @OneToMany(mappedBy = "articulo")
    @JsonIgnoreProperties("articulo")
    @JsonManagedReference("articulo-categoria")
    private List<ArtiCate> categorias;

}
