package com.example.Vuelos.repository;

import com.example.Vuelos.model.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VuelosRepository extends JpaRepository<Vuelos, Long> {

}