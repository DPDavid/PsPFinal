package com.example.Vuelos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vuelos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Vuelos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;
    private String origen;
    private int plazasDisponibles;

    public Vuelos(String destino, String origen, int plazasDisponibles) {
        this.destino = destino;
        this.origen = origen;
        this.plazasDisponibles = plazasDisponibles;
    }
}
