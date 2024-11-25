package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Contratista;

@Service
public interface ContratistaService {

    public void save(Contratista contratista);

    public Contratista findById(Long id);

    public Collection<Contratista> findAll();

    public void deleteById(Long id);

    public void update(Contratista contratista);

}
