package com.example.Hoteles.service;

import com.example.Hoteles.model.Hotel;
import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Long id);
    Hotel addHotel(Hotel hotel);
    List<Hotel> getAvailableHotels();
}