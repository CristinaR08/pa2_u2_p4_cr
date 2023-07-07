package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class AutorRepositoryImpl implements IAutorRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Autor autor) {
		this.entityManager.persist(autor);
	}

	@Override
	public void modificar(Autor autor) {
		this.entityManager.merge(autor);
	}

	@Override
	public Autor buscar(Integer id) {
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}
	
}
