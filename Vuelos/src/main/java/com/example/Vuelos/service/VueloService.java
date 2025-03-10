package com.example.Vuelos.service;

import com.example.Vuelos.model.Vuelos;

import java.util.List;

public interface VueloService {
    //Metodo para actualizar las plazas
    void actualizarPlazas(Long idVuelo, int totalPersonas);
    //Metodo para obtener vuelos disponibles
    List<Vuelos> obtenerVuelosDisponibles();
    //Metodo para guardar el vuelo
    void guardarVuelo(Vuelos vuelo);
}
