package com.example.Reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Reservas.model.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas, Long> {

}
