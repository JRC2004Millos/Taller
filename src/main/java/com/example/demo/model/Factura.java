package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Factura {

    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;
    private float costoTotal;
    private float saldo;
    private float abono;

    public Factura() {
    }

    public Factura(Date fecha, float costoTotal, float saldo, float abono) {
        this.fecha = fecha;
        this.costoTotal = costoTotal;
        this.saldo = saldo;
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getAbono() {
        return abono;
    }

    public void setAbono(float abono) {
        this.abono = abono;
    }

}
