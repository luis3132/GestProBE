package com.gestpro.gestpro.domain.service.interfaces.venta;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.gestpro.gestpro.domain.dto.venta.VentaNuevaDTO;
import com.gestpro.gestpro.persistence.entity.venta.Venta;

/**
 * 
 * @author Luis Andres Gonzalez Corzo
 */

public interface IVentaService {
    public List<Venta> findByEmpresa(String empresa);
    public List<Venta> findByToday(Date fechaVenta);
    public List<Venta> findByMonth(Date fechaVenta);
    public List<Venta> findByYear(Date fechaVenta);
    public List<Venta> findByDate(Date fechaVenta, Date fecha);
    public Optional<Venta> findById(String id);
    public Venta createVenta(VentaNuevaDTO venta);
    public Venta updateVenta(VentaNuevaDTO venta);
    public Boolean deleteVenta(String id);
}
