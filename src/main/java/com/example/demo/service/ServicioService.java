package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Servicio;

@Service
public interface ServicioService {

    public void save(Servicio servicio);

    public Servicio findById(Long id);

    public List<Servicio> findAll();

    public void deleteById(Long id);

    public void update(Servicio servicio);

    public List<Servicio> findByNombreContainingIgnoreCase(String nombre);

}
