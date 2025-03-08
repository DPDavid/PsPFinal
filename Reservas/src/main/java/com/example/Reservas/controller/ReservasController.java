package com.example.Reservas.controller;

import com.example.Reservas.model.Reservas;
import com.example.Reservas.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reservas")
public class ReservasController {
    @Autowired
    private ReservasService reservasService;

    @PostMapping
    public String crearReserva(@RequestBody Reservas reserva, @RequestParam int personas) {
        try {
            reservasService.realizarReserva(reserva, personas);
            return "Reserva creada con éxito";
        } catch (Exception e) {
            return "Error al crear reserva: " + e.getMessage();
        }
    }
}