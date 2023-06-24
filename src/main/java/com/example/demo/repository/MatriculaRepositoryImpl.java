package com.example.demo.repository;

import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
		
	}

	@Override
	public void modificar(Matricula matricula) {
		this.entityManager.merge(matricula);
		
	}

	@Override
	public Matricula buscar(Integer id) {
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
		
	}

}
