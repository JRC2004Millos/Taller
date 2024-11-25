package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tarifa;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {

}
