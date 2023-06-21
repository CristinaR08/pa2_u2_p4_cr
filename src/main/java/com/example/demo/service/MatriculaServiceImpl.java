package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Matricula;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Override
	public void agregar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
		
	}

	@Override
	public void actualizar(Matricula matricula) {
		this.matriculaRepository.modificar(matricula);
		
	}

	@Override
	public Matricula encontrar(Integer id) {
		return this.matriculaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.matriculaRepository.eliminar(id);
		
	}

}
