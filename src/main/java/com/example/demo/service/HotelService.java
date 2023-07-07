package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHotelRepository;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelService implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepo;

	@Override
	public void agregar(Hotel hotel) {
		this.hotelRepo.insertar(hotel);
	}

	@Override
	public void modificar(Hotel hotel) {
		this.hotelRepo.actualizar(hotel);
	}

	@Override
	public Hotel encontrar(Integer id) {
		return this.hotelRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.hotelRepo.eliminar(id);
	}
}
