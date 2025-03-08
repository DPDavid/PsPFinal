package com.example.Reservas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreUsuario;
    private String dni;
    private int vuelo;
    private int hotel;

    public long getHotelId() {
        return this.hotel;
    }
}
