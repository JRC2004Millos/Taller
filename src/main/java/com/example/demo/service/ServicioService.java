package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Servicio;

@Service
public interface ServicioService {

    public void save(Servicio servicio);

    public Servicio findById(Long id);

    public Collection<Servicio> findAll();

    public void deleteById(Long id);

    public void update(Servicio servicio);

}
