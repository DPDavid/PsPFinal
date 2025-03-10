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

    //Metodo para actualizar la cantidad de plazas en un vuel
    @Override
    public void actualizarPlazas(Long idVuelo, int totalPersonas) {
        Vuelos vuelo = vueloRepository.findById(idVuelo)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        if (vuelo.getPlazasDisponibles() < totalPersonas) {
            throw new RuntimeException("No hay suficientes plazas disponibles");
        }

        //Resta las plazas y guarda los cambios en la BD
        vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - totalPersonas);
        vueloRepository.save(vuelo);
    }

    //Metodo para obtener todos los vuelos disponibles
    @Override
    public List<Vuelos> obtenerVuelosDisponibles() {
        return vueloRepository.findAll();
    }

    //Metodo para guardar un vuelo en la BD
    @Override
    public void guardarVuelo(Vuelos vuelo) {
        vueloRepository.save(vuelo);
    }
}
