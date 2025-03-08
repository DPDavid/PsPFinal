package com.example.Hoteles.controller;

import com.example.Hoteles.model.Hotel;
import com.example.Hoteles.service.HotelService;
import com.example.Hoteles.service.HotelServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
    private final HotelService hotelService;
    private final HotelServiceImpl hotelServiceImpl;

    public HotelController(HotelService hotelService, HotelServiceImpl hotelServiceImpl) {
        this.hotelService = hotelService;
        this.hotelServiceImpl = hotelServiceImpl;
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/disponibles")
    public List<Hotel> getAvailableHotels() {
        return hotelService.getAvailableHotels();
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{id}/disponibilidad")
    public void actualizarDisponibilidad(@PathVariable Long id, @RequestParam boolean disponible) {
        hotelServiceImpl.actualizarDisponibilidad(id, disponible);
    }

}