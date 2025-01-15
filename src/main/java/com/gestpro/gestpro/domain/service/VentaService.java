package com.gestpro.gestpro.domain.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.venta.VentUnidNuevoDTO;
import com.gestpro.gestpro.domain.dto.venta.VentaNuevaDTO;
import com.gestpro.gestpro.domain.service.interfaces.venta.IVentUnidService;
import com.gestpro.gestpro.domain.service.interfaces.venta.IVentaService;
import com.gestpro.gestpro.persistence.entity.venta.VentUnid;
import com.gestpro.gestpro.persistence.entity.venta.VentUnidPK;
import com.gestpro.gestpro.persistence.entity.venta.Venta;
import com.gestpro.gestpro.persistence.repository.venta.VentUnidRepository;
import com.gestpro.gestpro.persistence.repository.venta.VentaRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class VentaService implements IVentaService, IVentUnidService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentUnidRepository ventUnidRepository;

    // Ventas

    @Override
    public Optional<Venta> findById(String id) {
        return ventaRepository.findById(id);
    }

    @Override
    public List<Venta> findByEmpresa(String empresa) {
        return ventaRepository.findByEmpresa(empresa);
    }

    @Override
    public List<Venta> findByToday(Date fechaVenta) {
        return ventaRepository.findByToday(fechaVenta);
    }

    @Override
    public List<Venta> findByMonth(Date fechaVenta) {
        return null;
    }

    @Override
    public List<Venta> findByYear(Date fechaVenta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Venta> findByDate(Date fechaVenta, Date fecha) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Venta createVenta(VentaNuevaDTO venta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Venta updateVenta(VentaNuevaDTO venta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean deleteVenta(String id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Ventas Unidades

    @Override
    public VentUnid createVentUnid(VentUnidNuevoDTO ventUnid) {
        return ventUnidRepository.save(convertVentUnid(ventUnid));
    }

    @Override
    public Boolean deleteVentUnid(VentUnidPK id) {
        if (ventUnidRepository.existsById(id)) {
            ventUnidRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converters

    private VentUnid convertVentUnid(VentUnidNuevoDTO ventUnid) {
        VentUnid ventUnidEntity = new VentUnid();
        VentUnidPK ventUnidPK = new VentUnidPK();

        Optional<Venta> venta = findById(ventUnid.getVenta());

        if (venta.isPresent()) {
            ventUnidPK.setUnidad(ventUnid.getUnidad());
            ventUnidPK.setVenta(ventUnid.getVenta());
            ventUnidEntity.setId(ventUnidPK);

            ventUnidEntity.setVenta(venta.get());
        }
        return ventUnidEntity;
    }

}
