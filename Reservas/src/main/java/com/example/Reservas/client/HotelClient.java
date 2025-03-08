package com.example.Reservas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Hoteles", url = "http://localhost:8002/hoteles")
public interface HotelClient {

    @PutMapping("/{id}/disponibilidad")
    void actualizarDisponibilidad(@PathVariable Long id, @RequestParam boolean disponible);
}
