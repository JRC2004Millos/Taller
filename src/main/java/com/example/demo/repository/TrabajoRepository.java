package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Trabajo;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {

}
