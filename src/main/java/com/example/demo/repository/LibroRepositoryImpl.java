package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro libro) {
		this.entityManager.persist(libro);
	}

	@Override
	public void modificar(Libro libro) {
		this.entityManager.merge(libro);
	}

	@Override
	public Libro buscar(Integer id) {
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}
}
