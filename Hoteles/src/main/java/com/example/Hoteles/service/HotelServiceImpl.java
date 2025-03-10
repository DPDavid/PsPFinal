package com.example.Hoteles.service;

import com.example.Hoteles.model.Hotel;
import com.example.Hoteles.repository.HotelRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    //Constructor para el repositorio
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        //Obtiene todos los hoteles
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        //Busca un hotel por ID
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        //Guarda un nuevo hotel en la BD
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAvailableHotels() {
        //Obtiene hoteles disponibles
        return hotelRepository.findByAvailable(true);
    }

    public void actualizarDisponibilidad(Long id, boolean disponible) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel no encontrado"));
        //Cambia la disponibilidad y guarda los cambios
        hotel.setAvailable(disponible);
        hotelRepository.save(hotel);
    }

}
