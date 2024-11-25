package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Contratista {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "contratista")
    private List<Tarifa> tarifas;

    @OneToMany(mappedBy = "contratista")
    private List<Trabajo> trabajos;

    private String nombre;

    private Long celular;

    public Contratista() {
    }

    public Contratista(String nombre, Long celular) {
        this.nombre = nombre;
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(List<Tarifa> servicios) {
        this.tarifas = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }
}
