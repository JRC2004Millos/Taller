package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Factura {

    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;
    private float costoTotal;
    private float abono;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura")
    private List<Trabajo> trabajos;

    public Factura() {
    }

    public Factura(Date fecha, float costoTotal, float abono) {
        this.fecha = fecha;
        this.costoTotal = costoTotal;
        this.abono = abono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public float getAbono() {
        return abono;
    }

    public void setAbono(float abono) {
        this.abono = abono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
