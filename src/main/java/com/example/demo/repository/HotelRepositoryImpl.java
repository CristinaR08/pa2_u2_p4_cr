package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements  IHotelRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);
		}

	@Override
	public Hotel buscar(Integer id) {
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Hotel seleccionarPorId(Integer id) {
		return this.entityManager.find(Hotel.class, id.SIZE);
	}
	
//cuando tengo una carga perezosa o carga bajo demanda significa darle una señal (ocupar en el repository un atributo de la relacion)
	//lo mas comun es hacerle un SIZE
}
