package com.example.Vuelos.controller;

import com.example.Vuelos.model.Vuelos;
import com.example.Vuelos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    //Endpoint para actualizar las plazas disponibles del vuelo
    @PutMapping("/{id}/{personas}")
    public String actualizarPlazas(@PathVariable("id") Long id, @PathVariable("personas") int personas) {
        try {
            vueloService.actualizarPlazas(id, personas);
            return "Plazas actualizadas con éxito";
        } catch (Exception e) {
            return "Error al actualizar las plazas: " + e.getMessage();
        }
    }

    //Endpoint para crear un nuevo vuelo
    @PostMapping
    public ResponseEntity<String> crearVuelo(@RequestBody Vuelos vuelo) {
        vueloService.guardarVuelo(vuelo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vuelo creado con éxito");
    }

    //Endpoint para obtener la lista de vuelos
    @GetMapping
    public List<Vuelos> obtenerVuelos() {
        return vueloService.obtenerVuelosDisponibles();
    }
}
