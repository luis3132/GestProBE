package com.gestpro.gestpro.persistence.entity.venta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestpro.gestpro.constants.MetodoPago;
import com.gestpro.gestpro.persistence.entity.cliente.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "venta")
public class Venta {
    
    @Id
    private String id;

    @Column(name = "fecha_venta")
    private String fechaVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @JsonBackReference("cliente-venta")
    @JsonIgnoreProperties("ventas")
    private Cliente cliente;

    private String pagacon;
    private String cambio;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_de_pago")
    private MetodoPago metodoPago;
}
