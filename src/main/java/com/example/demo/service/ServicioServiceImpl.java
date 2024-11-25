package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Servicio;
import com.example.demo.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    ServicioRepository servicioRepository;

    @Override
    public void save(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public Servicio findById(Long id) {
        return servicioRepository.findById(id).get();
    }

    @Override
    public Collection<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        servicioRepository.deleteById(id);
    }

    @Override
    public void update(Servicio servicio) {
        servicioRepository.save(servicio);
    }

}
