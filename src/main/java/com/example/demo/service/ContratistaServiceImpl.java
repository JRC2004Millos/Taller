package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contratista;
import com.example.demo.repository.ContratistaRepository;

@Service
public class ContratistaServiceImpl implements ContratistaService {

    @Autowired
    ContratistaRepository contratistaRepository;

    @Override
    public void save(Contratista contratista) {
        contratistaRepository.save(contratista);
    }

    @Override
    public Contratista findById(Long id) {
        return contratistaRepository.findById(id).get();
    }

    @Override
    public List<Contratista> findAll() {
        return contratistaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        contratistaRepository.deleteById(id);
    }

    @Override
    public void update(Contratista contratista) {
        contratistaRepository.save(contratista);
    }

    @Override
    public List<Contratista> findByNombreContainingIgnoreCase(String nombre) {
        return contratistaRepository.findByNombreContainingIgnoreCase(nombre);
    }

}
