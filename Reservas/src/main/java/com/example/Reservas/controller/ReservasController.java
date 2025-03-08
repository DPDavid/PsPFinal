package com.example.Reservas.controller;

import com.example.Reservas.model.Reservas;
import com.example.Reservas.service.ReservasService;
import com.example.Reservas.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @Autowired
    private ReservasRepository reservasRepository;

    // Endpoint para crear la reserva (ya lo tienes)
    @PostMapping
    public String crearReserva(@RequestBody Reservas reserva, @RequestParam int personas) {
        try {
            reservasService.realizarReserva(reserva, personas);
            return "Reserva creada con éxito";
        } catch (Exception e) {
            return "Error al crear reserva: " + e.getMessage();
        }
    }

    // Endpoint para obtener todas las reservas
    @GetMapping
    public List<Reservas> obtenerReservas() {
        return reservasRepository.findAll();  // Devuelve todas las reservas de la base de datos
    }
}
