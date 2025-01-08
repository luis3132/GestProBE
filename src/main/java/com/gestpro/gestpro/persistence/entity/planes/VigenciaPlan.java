package com.gestpro.gestpro.persistence.entity.planes;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestpro.gestpro.persistence.entity.Empresa;

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
 * @author Luis Andres Gonzalez Corzo
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vigencia_plan")
public class VigenciaPlan {
    
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa", referencedColumnName = "nit")
    @JsonManagedReference("empresa-plan")
    @JsonIgnoreProperties("vigenciasPlan")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planes", referencedColumnName = "id")
    private Planes plan;
    
    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

}
