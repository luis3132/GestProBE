package com.gestpro.gestpro.persistence.repository.venta;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestpro.gestpro.persistence.entity.venta.Venta;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface VentaRepository extends JpaRepository<Venta, String> {
    
    @Query("SELECT v FROM Venta v WHERE v.empresa = ?1")
    public List<Venta> findByEmpresa(String empresa);

    @Query("SELECT v FROM Venta v WHERE FUNCTION('DATE', v.fechaVenta) = ?1")
    public List<Venta> findByToday(Date fechaVenta);

    @Query("SELECT v FROM Venta v WHERE FUNCTION('MONTH', v.fechaVenta) = ?1 AND FUNCTION('YEAR', v.fechaVenta) = ?2")
    public List<Venta> findByMonth(Date fechaVenta);
}
