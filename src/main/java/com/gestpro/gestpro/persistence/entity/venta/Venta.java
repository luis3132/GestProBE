package com.gestpro.gestpro.persistence.entity.venta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestpro.gestpro.constants.MetodoPago;
import com.gestpro.gestpro.persistence.entity.Usuario;
import com.gestpro.gestpro.persistence.entity.cliente.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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

    @Column(name = "fecha_venta", nullable = false)
    private String fechaVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "cliente", referencedColumnName = "cedula"),
        @JoinColumn(name = "empresa", referencedColumnName = "empresa")
    })
    @JsonBackReference("cliente-venta")
    @JsonIgnoreProperties("ventas")
    private Cliente cliente;

    @Column(name = "empresa", nullable = false, insertable = false, updatable = false)
    private String empresa;

    @Column(name = "pagacon", nullable = false)
    private String pagacon;
    private String cambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", referencedColumnName = "cedula")
    @JsonBackReference("usuario-venta")
    @JsonIgnoreProperties(value = {"empleos", "empresas"})
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_de_pago")
    private MetodoPago metodoPago;
}
