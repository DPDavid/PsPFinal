package com.example.Vuelos.service;

import com.example.Vuelos.model.Vuelos;

import java.util.List;

public interface VueloService {
    void actualizarPlazas(Long idVuelo, int totalPersonas);
    List<Vuelos> obtenerVuelosDisponibles();
    void guardarVuelo(Vuelos vuelo);
}
