package com.example.demo.service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Factura;

@Service
public interface FacturaService {

    public void save(Factura factura);

    public Factura findById(Long id);

    public List<Factura> findByFecha(Date fecha);

    public void deleteById(Long id);

    public void update(Factura factura);

    public Collection<Factura> findAll();
}
