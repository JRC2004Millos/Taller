package com.example.demo.service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Factura;
import com.example.demo.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Collection<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public void save(Factura factura) {
        facturaRepository.save(factura);
    }

    @Override
    public Factura findById(Long id) {
        return facturaRepository.findById(id).get();
    }

    @Override
    public List<Factura> findByFecha(Date fecha) {
        return facturaRepository.findByFecha(fecha);
    }

    @Override
    public void deleteById(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public void update(Factura factura) {
        facturaRepository.save(factura);
    }

}
