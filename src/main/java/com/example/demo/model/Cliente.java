package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Long celular;
    private String correo;

    public Cliente() {
    }

    public Cliente(String nombre, Long celular, String correo) {
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
