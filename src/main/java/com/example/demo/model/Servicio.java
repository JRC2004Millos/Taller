package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Servicio {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "servicio")
    private List<Tarifa> tarifas;

    @OneToMany(mappedBy = "servicio")
    private List<Trabajo> trabajos;

    private String nombre;

    public Servicio() {
    }

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Tarifa> getContratistas() {
        return tarifas;
    }

    public void setContratistas(List<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
