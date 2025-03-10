package com.example.Hoteles.service;

import com.example.Hoteles.model.Hotel;
import java.util.List;

public interface HotelService {
    //Obtiene todos los hoteles
    List<Hotel> getAllHotels();
    //Obtiene un hotel por id
    Hotel getHotelById(Long id);
    //Agrega un hotel nuevo
    Hotel addHotel(Hotel hotel);
    //Obtiene hoteles disponibles
    List<Hotel> getAvailableHotels();
}