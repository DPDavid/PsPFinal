package com.example.Hoteles.controller;

import com.example.Hoteles.model.Hotel;
import com.example.Hoteles.service.HotelService;
import com.example.Hoteles.service.HotelServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
    //Interfaz de servicios de hoteles
    private final HotelService hotelService;
    //Implementacion del servicio
    private final HotelServiceImpl hotelServiceImpl;

    //Constructor para las dependencias de los servicios
    public HotelController(HotelService hotelService, HotelServiceImpl hotelServiceImpl) {
        this.hotelService = hotelService;
        this.hotelServiceImpl = hotelServiceImpl;
    }

    //Metodo para obtener todos los hoteles
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    //Metodo para obtener los hoteles por su id
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    //Metodo para obtener todos los hoteles disponibles
    @GetMapping("/disponibles")
    public List<Hotel> getAvailableHotels() {
        return hotelService.getAvailableHotels();
    }

    //Metodo para agregar un nuevo hotel
    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    //Metodo para actualizar la disponibilidad de un hotel especifico
    @PutMapping("/{id}/disponibilidad")
    public void actualizarDisponibilidad(@PathVariable Long id, @RequestParam boolean disponible) {
        hotelServiceImpl.actualizarDisponibilidad(id, disponible);
    }

}