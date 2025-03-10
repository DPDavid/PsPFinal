package com.example.Hoteles.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hoteles")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double price;
    private boolean available;
}
