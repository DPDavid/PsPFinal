package com.example.Vuelos.service;

import com.example.Vuelos.model.Vuelos;
import com.example.Vuelos.repository.VuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImpl implements VueloService {

    @Autowired
    private VuelosRepository vueloRepository;

    @Override
    public void actualizarPlazas(Long idVuelo, int totalPersonas) {
        Vuelos vuelo = vueloRepository.findById(idVuelo)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        if (vuelo.getPlazasDisponibles() < totalPersonas) {
            throw new RuntimeException("No hay suficientes plazas disponibles");
        }

        vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - totalPersonas);
        vueloRepository.save(vuelo);
    }

    @Override
    public List<Vuelos> obtenerVuelosDisponibles() {
        return vueloRepository.findAll();
    }
}
