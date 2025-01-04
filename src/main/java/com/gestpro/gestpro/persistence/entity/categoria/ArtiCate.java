package com.gestpro.gestpro.persistence.entity.categoria;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestpro.gestpro.persistence.entity.Articulo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "arti_cate")
public class ArtiCate {
    
    @EmbeddedId
    private ArtiCatePK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoria")
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articulo")
    @JoinColumn(name = "articulo", referencedColumnName = "id")
    @JsonBackReference("articulo-categoria")
    @JsonIgnoreProperties("categorias")
    private Articulo articulo;
}
