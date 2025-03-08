package com.example.Reservas.service;

import com.example.Reservas.client.HotelClient;
import com.example.Reservas.client.VuelosClient;
import com.example.Reservas.repository.ReservasRepository;
import com.example.Reservas.model.Reservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private VuelosClient vuelosClient;

    @Autowired
    private HotelClient hotelClient;

    @Autowired
    private CircuitBreakerFactory<?, ?> circuitBreakerFactory;

    @Override
    @Transactional
    public void realizarReserva(Reservas reserva, int totalPersonas) {
        // Configuración del Circuit Breaker para servicio de vuelos
        circuitBreakerFactory.create("vuelosService").run(() -> {
            vuelosClient.actualizarPlazas(reserva.getVuelo(), totalPersonas);
            return null;
        }, throwable -> fallbackReserva());

        reservasRepository.save(reserva);

        // Llamar a Hoteles para actualizar la disponibilidad usando el ID del hotel
        hotelClient.actualizarDisponibilidad(reserva.getHotelId(), false);  // Usar getHotelId() en lugar de getHotel()
    }

    private Void fallbackReserva() {
        System.out.println("Servicio de vuelos no disponible. No se pudo completar la reserva.");
        throw new RuntimeException("Error al contactar con el servicio de vuelos.");
    }
}
