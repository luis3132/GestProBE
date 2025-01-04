package com.gestpro.gestpro.persistence.entity.venta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestpro.gestpro.persistence.entity.Unidad;

import jakarta.persistence.Column;
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
@Table(name = "vent_unid")
public class VentUnid {
    
    @EmbeddedId
    private VentUnidPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("unidad")
    @JoinColumn(name = "unidad", referencedColumnName = "sku")
    @JsonIgnoreProperties("local")
    private Unidad unidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("venta")
    @JoinColumn(name = "venta", referencedColumnName = "id")
    @JsonBackReference("venta-unidad")
    private Venta venta;

    @Column(name = "precio_final")
    private Long precioFinal;

}
