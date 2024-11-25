package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;

@Service
public interface ClienteService {

    public Cliente findById(Long id);

    public List<Cliente> findAll();

    public void add(Cliente cliente);

    public void update(Cliente cliente);

    public void deleteById(Long id);

    public List<Cliente> findByNombreContainingIgnoreCase(String nombre);
}
