package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Factura;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.sql.Date;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    List<Factura> findByFecha(Date fecha);

}
