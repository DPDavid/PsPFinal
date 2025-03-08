package com.example.Reservas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vuelos", url = "http://localhost:8003")
public interface VuelosClient {
    @PutMapping("/vuelos/{id}/{personas}")
    void actualizarPlazas(@PathVariable("id") int vueloId, @PathVariable("personas") int totalPersonas);
}

