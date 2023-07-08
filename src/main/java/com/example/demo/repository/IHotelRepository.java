package com.example.demo.repository;

import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	public void insertar(Hotel hotel);
	public void actualizar(Hotel hotel);
	public Hotel buscar(Integer id);
	public void eliminar(Integer id);
	public Hotel seleccionarPorId(Integer id);
}
