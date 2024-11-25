package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contratista;

@Repository
public interface ContratistaRepository extends JpaRepository<Contratista, Long> {

}
